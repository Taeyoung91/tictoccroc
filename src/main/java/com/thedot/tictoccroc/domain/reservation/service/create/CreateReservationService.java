package com.thedot.tictoccroc.domain.reservation.service.create;

import com.thedot.tictoccroc.domain.reservation.dto.CreateReservationReq;
import com.thedot.tictoccroc.domain.reservation.dto.CreateReservationRes;

public interface CreateReservationService {

  CreateReservationRes createOne(CreateReservationReq createReservationReq);
}
