package com.dziem.fitnesstrackerweb.data;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class ExercisesDataLoader implements ApplicationRunner {
    private ExercisesDataLoader exercisesRepository;

    public ExercisesDataLoader(ExercisesDataLoader exercisesRepository) {
        this.exercisesRepository = exercisesRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
