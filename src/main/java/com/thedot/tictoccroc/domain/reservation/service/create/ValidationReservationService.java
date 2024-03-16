package com.thedot.tictoccroc.domain.reservation.service.create;

import com.thedot.tictoccroc.domain.reservation.dto.CreateReservationReq;

public interface ValidationReservationService {

  boolean validate(CreateReservationReq createReservationReq);
}
