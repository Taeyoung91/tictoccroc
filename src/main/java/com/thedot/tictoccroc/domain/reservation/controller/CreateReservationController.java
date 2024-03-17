package com.thedot.tictoccroc.domain.reservation.controller;

import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationReq;
import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationRes;
import com.thedot.tictoccroc.domain.reservation.service.create.CreateReservationService;
import com.thedot.tictoccroc.global.dto.ApiRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class CreateReservationController {

  private final CreateReservationService createReservationServiceImpl;

  @Operation(summary = "예약 생성", description = "예약 요청 정보를 받아 예약을 생성합니다.")
  @PostMapping
  public ApiRes<CreateReservationRes> createOne(@RequestBody CreateReservationReq createReservationReq) {
    CreateReservationRes reservation = createReservationServiceImpl.createOne(createReservationReq);

    return reservation != null ? new ApiRes<>(reservation) : new ApiRes<>(false, "RE001", "예약 실패"); /// todo :: AOP Exception 처리
  }
}
