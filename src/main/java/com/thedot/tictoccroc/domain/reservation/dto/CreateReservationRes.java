package com.thedot.tictoccroc.domain.reservation.dto;

import com.thedot.tictoccroc.domain.model.Reservation;
import lombok.Getter;

@Getter
public class CreateReservationRes {

  private final long reservationId;

  public CreateReservationRes(Reservation reservation) {
    this.reservationId = reservation.getId();
  }
}
