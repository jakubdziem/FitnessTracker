package com.dziem.fitnesstrackerweb.web.controller;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import com.dziem.fitnesstrackerweb.biz.service.ExerciseService;
import com.dziem.fitnesstrackerweb.data.ExerciseRepository;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/exercises")
@Log4j2
public class ExercisesController {
    private final ExerciseService exerciseService;
    public ExercisesController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public String showExercisesPage() {
        return "exercises";
    }
    @ModelAttribute("exercises")
    public Page<Exercise> getExercises(@PageableDefault(size=10) Pageable page) {
        return exerciseService.findAll(page);
    }
    @ModelAttribute("exercise")
    public Exercise getExercise() {
        return new Exercise();
    }
    @PostMapping
    public String saveExercise(@Valid Exercise exercise, Errors errors) {
        log.info(exercise);
        if (!errors.hasErrors()) {
            exerciseService.save(exercise);
            return "redirect:exercises";
        }
        return "exercises";
    }
    @PostMapping(params = "action=delete")
    public String deleteExercises(@RequestParam Optional<List<Long>> selections) {
        log.info(selections);
        if (selections.isPresent()) {
            exerciseService.deleteAllById(selections.get());
        }
        return "redirect:exercises";
    }

    @PostMapping(params = "action=edit")
    public String editExercise(@RequestParam Optional<List<Long>> selections, Model model) {
        log.info(selections);
        if (selections.isPresent()) {
            Optional<Exercise> exercise = exerciseService.findById(selections.get().get(0));
            model.addAttribute("exercise", exercise);
        }
        return "exercises";
    }
    @PostMapping(params = "cancel=true")
    public String cancelEditing() {
        return "redirect:exercises";
    }
    @PostMapping(params = "action=import")
    public String importCSV(@RequestParam MultipartFile csvFile) {
        log.info("File name: " + csvFile.getOriginalFilename());
        log.info("File size: " + csvFile.getSize());
        try {
            exerciseService.importCSV(csvFile.getInputStream(), csvFile.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:exercises";
    }
}
