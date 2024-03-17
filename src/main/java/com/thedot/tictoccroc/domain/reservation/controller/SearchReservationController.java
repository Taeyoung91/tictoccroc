package com.thedot.tictoccroc.domain.reservation.controller;

import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationParentRes;
import com.thedot.tictoccroc.domain.reservation.service.search.SearchReservationService;
import com.thedot.tictoccroc.global.dto.ApiRes;
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

  @GetMapping("/courseSchedule/{courseScheduleId}")
  public ApiRes<List<SearchReservationParentRes>> parentsByCourseScheduleId(@PathVariable Long courseScheduleId) {
    return new ApiRes<>(searchReservationServiceImpl.parentsByCourseScheduleId(courseScheduleId));
  }
}
