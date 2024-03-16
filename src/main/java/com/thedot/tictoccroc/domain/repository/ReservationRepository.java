package com.thedot.tictoccroc.domain.repository;

import com.thedot.tictoccroc.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
