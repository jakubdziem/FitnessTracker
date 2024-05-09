package com.dziem.fitnesstrackerweb.data;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import com.dziem.fitnesstrackerweb.biz.model.SuggestedExercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestedExerciseRepository extends CrudRepository<SuggestedExercise,Long> {
}
