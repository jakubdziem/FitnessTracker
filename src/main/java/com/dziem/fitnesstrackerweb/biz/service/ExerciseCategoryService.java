package com.dziem.fitnesstrackerweb.biz.service;

import com.dziem.fitnesstrackerweb.biz.model.ExerciseCategory;
import com.dziem.fitnesstrackerweb.data.ExerciseCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseCategoryService {
    private final ExerciseCategoryRepository exerciseCategoryRepository;

    public ExerciseCategoryService(ExerciseCategoryRepository exerciseCategoryRepository) {
        this.exerciseCategoryRepository = exerciseCategoryRepository;
    }

    public Iterable<ExerciseCategory> findAll() {
        return exerciseCategoryRepository.findAll();
    }
}
