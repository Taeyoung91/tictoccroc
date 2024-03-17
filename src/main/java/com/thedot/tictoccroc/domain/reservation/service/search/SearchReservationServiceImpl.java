package com.thedot.tictoccroc.domain.reservation.service.search;

import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationParentRes;
import com.thedot.tictoccroc.domain.reservation.dto.search.SearchReservationRes;
import com.thedot.tictoccroc.domain.reservation.repository.ReservationInReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchReservationServiceImpl implements SearchReservationService {

  private final ReservationInReservationRepository reservationInReservationRepository;

  @Override
  public List<SearchReservationParentRes> parentsByCourseScheduleId(Long courseScheduleId) {
    return reservationInReservationRepository.findByCourseScheduleId(courseScheduleId).stream().map(SearchReservationParentRes::new).collect(Collectors.toList());
  }

  @Override
  public List<SearchReservationRes> byCourseScheduleId(Long courseScheduleId) {
    return reservationInReservationRepository.findByCourseScheduleId(courseScheduleId).stream().map(SearchReservationRes::new).collect(Collectors.toList());
  }
}
