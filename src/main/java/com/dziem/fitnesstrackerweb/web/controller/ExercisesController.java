package com.dziem.fitnesstrackerweb.web.controller;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import com.dziem.fitnesstrackerweb.data.ExerciseRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {
    ExerciseRepository exerciseRepository;
    public ExercisesController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping
    public String showPeoplePage() {
        return "exercises";
    }
    @ModelAttribute("exercises")
    public Iterable<Exercise> getPeople() {
        return exerciseRepository.findAll();
    }
    @ModelAttribute("exercise")
    public Exercise getExercise() {
        return new Exercise();
    }
    @PostMapping
    public String saveExercise(@Valid Exercise exercise, Errors errors) {
        if (!errors.hasErrors()) {
            exerciseRepository.save(exercise);
            return "redirect:exercises";
        }
        return "exercises";
    }
}
