package com.thedot.tictoccroc.domain.reservation.repository;

import com.thedot.tictoccroc.domain.model.Reservation;
import com.thedot.tictoccroc.domain.repository.ReservationRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationInReservationRepository extends ReservationRepository {

  @Query("SELECT SUM(r.numberOfParticipants) FROM Reservation r WHERE r.courseSchedule.id = :courseScheduleId")
  int findNumberOfChildrenByCourseScheduleId(@Param("courseScheduleId") Long courseScheduleId);

  Optional<Reservation> findByParentIdAndCourseScheduleId(@Param("parentId") Long parentId, @Param("courseScheduleId") Long courseScheduleId);
}
