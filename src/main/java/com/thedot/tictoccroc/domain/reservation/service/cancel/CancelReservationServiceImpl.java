package com.thedot.tictoccroc.domain.reservation.service.cancel;

import com.thedot.tictoccroc.domain.reservation.repository.ReservationInReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CancelReservationServiceImpl implements CancelReservationService {

  private final ReservationInReservationRepository reservationInReservationRepository;


  @Override
  public boolean cancelOne(Long reservationId) {
    if (!validation(reservationId)) {
      return false;
    }

    reservationInReservationRepository.deleteById(reservationId);

    return true;
  }

  private boolean validation(Long reservationId) {
    if (!existReservation(reservationId)) {
      return false;
    }

    return true;
  }

  private boolean existReservation(Long reservationId) {
    return reservationInReservationRepository.existsById(reservationId);
  }

}
