package com.dziem.fitnesstrackerweb.web.controller;

import com.dziem.fitnesstrackerweb.biz.model.ExerciseCategory;
import com.dziem.fitnesstrackerweb.biz.model.SuggestedExercise;
import com.dziem.fitnesstrackerweb.biz.service.ExerciseCategoryService;
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
    private final ExerciseCategoryService exerciseCategoryService;

    public SuggestedExercisesController(SuggestedExerciseService suggestedExerciseService, ExerciseCategoryService exerciseCategoryService) {
        this.suggestedExerciseService = suggestedExerciseService;
        this.exerciseCategoryService = exerciseCategoryService;
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
    @ModelAttribute("exerciseCategories")
    public Iterable<ExerciseCategory> getExercisesCategories() {
        return exerciseCategoryService.findAll();
    }
    @ModelAttribute("exerciseCategory")
    public ExerciseCategory getExerciseCategory() {
        return new ExerciseCategory();
    }
}