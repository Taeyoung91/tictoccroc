package com.thedot.tictoccroc.domain.reservation.dto.search;

import com.thedot.tictoccroc.domain.model.Reservation;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class SearchReservationRes {

  private final String parentName;

  private final String parentEmailAddress;

  private final int numberOfParticipants;

  private final String createAt;

  public SearchReservationRes(Reservation reservation) {
    this.parentName = reservation.getParent().getName();
    this.parentEmailAddress = reservation.getParent().getEmailAddress();
    this.numberOfParticipants = reservation.getNumberOfParticipants();
    this.createAt = reservation.getCreateAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
  }
}
