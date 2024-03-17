package com.thedot.tictoccroc.domain.reservation.service.search;

import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationParentRes;
import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationRes;

import java.util.List;

public interface SearchReservationService {

  List<SearchReservationParentRes> parentsByCourseScheduleId(Long courseScheduleId);

  List<SearchReservationRes> byCourseScheduleId(Long courseScheduleId);
}
