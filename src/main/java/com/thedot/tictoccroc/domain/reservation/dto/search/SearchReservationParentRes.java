package com.thedot.tictoccroc.domain.reservation.dto.search;

import com.thedot.tictoccroc.domain.model.Reservation;
import lombok.Getter;

@Getter
public class SearchReservationParentRes {


  private final String parentName;

  private final String parentEmailAddress;

  public SearchReservationParentRes(Reservation reservation) {
    this.parentName = reservation.getParent().getName();
    this.parentEmailAddress = reservation.getParent().getEmailAddress();
  }

}
