package com.thedot.tictoccroc.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "reservation")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private Parent parent;

  @ManyToOne(fetch = FetchType.LAZY)
  private CourseSchedule courseSchedule;

  private int numberOfParticipants;

}