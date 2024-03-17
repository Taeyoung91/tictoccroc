package com.thedot.tictoccroc.domain.reservation.service.create;

import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationReq;
import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationRes;

public interface CreateReservationService {

  CreateReservationRes createOne(CreateReservationReq createReservationReq);
}
