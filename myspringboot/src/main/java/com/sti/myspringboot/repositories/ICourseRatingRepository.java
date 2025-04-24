package com.sti.myspringboot.repositories;

import com.sti.myspringboot.entities.CourseRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRatingRepository extends JpaRepository<CourseRating, Long> {
}
