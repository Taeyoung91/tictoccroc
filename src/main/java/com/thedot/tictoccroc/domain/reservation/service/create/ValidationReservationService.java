package com.thedot.tictoccroc.domain.reservation.service.create;

import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationReq;

public interface ValidationReservationService {

  boolean validate(CreateReservationReq createReservationReq);
}
