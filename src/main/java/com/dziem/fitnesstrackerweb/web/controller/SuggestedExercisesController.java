package com.dziem.fitnesstrackerweb.web.controller;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import com.dziem.fitnesstrackerweb.biz.model.SuggestedExercise;
import com.dziem.fitnesstrackerweb.biz.service.SuggestedExerciseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example-exercises")
@Log4j2
public class SuggestedExercisesController {
    private final SuggestedExerciseService suggestedExerciseService;

    public SuggestedExercisesController(SuggestedExerciseService suggestedExerciseService) {
        this.suggestedExerciseService = suggestedExerciseService;
    }
    @GetMapping
    public String showSuggestedExercisesPage() {
        return "example-exercises";
    }
    @ModelAttribute("exampleExercises")
    public Iterable<SuggestedExercise> getSuggestedExercises() {
        return suggestedExerciseService.findAll();
    }
    @ModelAttribute("exampleExercise")
    public SuggestedExercise getSuggestedExercise() {
        return new SuggestedExercise();
    }
}
