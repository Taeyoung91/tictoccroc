package com.thedot.tictoccroc.domain.reservation.controller;

import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationParentRes;
import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationRes;
import com.thedot.tictoccroc.domain.reservation.service.search.SearchReservationService;
import com.thedot.tictoccroc.global.dto.ApiRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class SearchReservationController {

  private final SearchReservationService searchReservationServiceImpl;

  @Operation(summary = "예약자 현황", description = "매장별 수업 ID 를 받아, 해당 수업의 예약자 현황 리스트를 보여줍니다.")
  @GetMapping("/courseSchedule/{courseScheduleId}/parent")
  public ApiRes<List<SearchReservationParentRes>> parentsByCourseScheduleId(@PathVariable Long courseScheduleId) {
    return new ApiRes<>(searchReservationServiceImpl.parentsByCourseScheduleId(courseScheduleId));
  }

  @Operation(summary = "예약 이력 현황", description = "매장별 수업 ID 를 받아, 해당 수업의 이력 현황을 보여줍니다.")
  @GetMapping("/courseSchedule/{courseScheduleId}")
  public ApiRes<List<SearchReservationRes>> byCourseScheduleId(@PathVariable Long courseScheduleId) {
    return new ApiRes<>(searchReservationServiceImpl.byCourseScheduleId(courseScheduleId));
  }
}
