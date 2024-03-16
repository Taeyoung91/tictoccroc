package com.thedot.tictoccroc.domain.repository;

import com.thedot.tictoccroc.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
