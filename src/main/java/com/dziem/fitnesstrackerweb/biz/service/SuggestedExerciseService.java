package com.dziem.fitnesstrackerweb.biz.service;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import com.dziem.fitnesstrackerweb.biz.model.SuggestedExercise;
import com.dziem.fitnesstrackerweb.data.SuggestedExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestedExerciseService {
    private final SuggestedExerciseRepository suggestedExerciseRepository;

    public SuggestedExerciseService(SuggestedExerciseRepository suggestedExerciseRepository) {
        this.suggestedExerciseRepository = suggestedExerciseRepository;
    }

    public Iterable<SuggestedExercise> findAll() {
        return suggestedExerciseRepository.findAll();
    }
}
