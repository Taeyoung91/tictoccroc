package com.thedot.tictoccroc.domain.reservation.controller;

import com.thedot.tictoccroc.domain.reservation.service.cancel.CancelReservationService;
import com.thedot.tictoccroc.global.dto.ApiRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class CancelReservationController {

  private final CancelReservationService cancelReservationServiceImpl;

  @DeleteMapping("/{reservationId}")
  public ApiRes<Void> cancelOne(@PathVariable Long reservationId) {
    boolean success = cancelReservationServiceImpl.cancelOne(reservationId);

    return success ? new ApiRes<>() : new ApiRes<>(false, "RC001", "예약 취소 실패");
  }
}
