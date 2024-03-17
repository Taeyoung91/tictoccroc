package com.thedot.tictoccroc.domain.reservation.dto.create;

import lombok.Getter;

@Getter
public class CreateReservationReq {

  private long parentId;
  private long courseScheduleId;
  private int numberOfParticipants;
}
