package com.thedot.tictoccroc.domain.reservation.service.create;

import com.thedot.tictoccroc.domain.model.CourseSchedule;
import com.thedot.tictoccroc.domain.repository.CourseScheduleRepository;
import com.thedot.tictoccroc.domain.repository.ParentRepository;
import com.thedot.tictoccroc.domain.reservation.dto.create.CreateReservationReq;
import com.thedot.tictoccroc.domain.reservation.repository.CourseInReservationRepository;
import com.thedot.tictoccroc.domain.reservation.repository.ReservationInReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidationReservationServiceImpl implements ValidationReservationService {

  private final ParentRepository parentRepository;
  private final CourseScheduleRepository courseScheduleRepository;
  private final CourseInReservationRepository courseInReservationRepository;
  private final ReservationInReservationRepository reservationInReservationRepository;

  @Override
  public boolean validate(CreateReservationReq createReservationReq) {
    if (!parentExists(createReservationReq.getParentId())) { /// todo : return 타입이 boolean -> void.. 여기서 직접 Exception 발생 후 AOP를 통해 ApiRes 코드, 결과 메시지 생성하여 응답처리
      return false;
    }

    if (!courseScheduleValidation(createReservationReq.getCourseScheduleId())) {
      return false;
    }

    if (!isValidNumberOfParticipants(createReservationReq.getCourseScheduleId(), createReservationReq.getNumberOfParticipants())) {
      return false;
    }

    if (isDuplicateReservation(createReservationReq)) {
      return false;
    }

    return true;
  }

  private boolean parentExists(Long parentId) {
    return parentRepository.findById(parentId).isPresent();
  }

  private boolean courseScheduleValidation(Long courseScheduleId) {
    Optional<CourseSchedule> courseScheduleOptional = courseScheduleRepository.findById(courseScheduleId);

    if (courseScheduleOptional.isEmpty()) {
      return false;
    }

    if (!isValidDate(courseScheduleOptional.get().getDate())) {
      return false;
    }

    return true;
  }

  private boolean isValidDate(Date reservationDate) {
    Calendar calendar = Calendar.getInstance();

    calendar.add(Calendar.DAY_OF_MONTH, 1);
    Date minDate = calendar.getTime();

    calendar.add(Calendar.DAY_OF_MONTH, 13);
    Date maxDate = calendar.getTime();

    return !reservationDate.before(minDate) && !reservationDate.after(maxDate);
  }

  private boolean isValidNumberOfParticipants(Long courseScheduleId, int numberOfParticipants) {
    int maxParticipants = courseInReservationRepository.findMaxParticipantsByCourseScheduleId(courseScheduleId);
    int currentReservedParticipants = reservationInReservationRepository.findNumberOfChildrenByCourseScheduleId(courseScheduleId).orElse(0);

    return maxParticipants >= currentReservedParticipants + numberOfParticipants;
  }

  private boolean isDuplicateReservation(CreateReservationReq createReservationReq) {
    return reservationInReservationRepository.findByParentIdAndCourseScheduleId(createReservationReq.getParentId(), createReservationReq.getCourseScheduleId()).isPresent();
  }
}
