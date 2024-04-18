package com.dziem.fitnesstrackerweb.data;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise,Long> {
}
