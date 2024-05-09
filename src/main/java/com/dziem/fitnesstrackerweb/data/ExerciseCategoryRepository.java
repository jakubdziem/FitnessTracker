package com.dziem.fitnesstrackerweb.data;

import com.dziem.fitnesstrackerweb.biz.model.ExerciseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseCategoryRepository extends CrudRepository<ExerciseCategory,Long> {

}
