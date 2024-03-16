package com.thedot.tictoccroc.domain.reservation.repository;

import com.thedot.tictoccroc.domain.repository.CourseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseInReservationRepository extends CourseRepository {
  @Query("SELECT c.maxParticipants FROM CourseSchedule cs JOIN cs.course c WHERE cs.id = :courseScheduleId")
  int findMaxParticipantsByCourseScheduleId(@Param("courseScheduleId") Long courseScheduleId);


}
