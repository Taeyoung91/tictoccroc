package com.thedot.tictoccroc.domain.reservation.service.create;

import com.thedot.tictoccroc.domain.model.CourseSchedule;
import com.thedot.tictoccroc.domain.model.Parent;
import com.thedot.tictoccroc.domain.model.Reservation;
import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationReq;
import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationRes;
import com.thedot.tictoccroc.domain.reservation.repository.ReservationInReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateReservationServiceImpl implements CreateReservationService {

  private final ValidationReservationService validationReservationServiceImpl;
  private final ReservationInReservationRepository reservationInReservationRepository;

  @Override
  public CreateReservationRes createOne(CreateReservationReq createReservationReq) {
    if (!validate(createReservationReq)) {
      return null;
    }

    Reservation reservation = save(createReservationReq);

    return new CreateReservationRes(reservation);
  }

  private Reservation save(CreateReservationReq createReservationReq) {
    return reservationInReservationRepository.save(Reservation.builder()
      .parent(Parent.builder().id(createReservationReq.getParentId()).build())
      .courseSchedule(CourseSchedule.builder().id(createReservationReq.getCourseScheduleId()).build())
      .numberOfParticipants(createReservationReq.getNumberOfParticipants())
      .createAt(LocalDateTime.now())
      .build());
  }

  private boolean validate(CreateReservationReq createReservationReq) {
    return validationReservationServiceImpl.validate(createReservationReq);
  }


}
