package com.dziem.fitnesstrackerweb.biz.service;

import com.dziem.fitnesstrackerweb.biz.model.Exercise;
import com.dziem.fitnesstrackerweb.data.ExerciseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipInputStream;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Page<Exercise> findAll(Pageable pageable) {
        return exerciseRepository.findAll(pageable);
    }

    public void deleteAllById(List<Long> ids) {
        exerciseRepository.deleteAllById(ids);
    }

    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    public void importCSV(InputStream csvFileStream, String fileName) {
        try {
            InputStreamReader inputStreamReader;
//            byte[] maybeZipBytes = csvFileStream.readNBytes(4);
//            byte[] zipBytes = HexFormat.of().parseHex("504b0304");
            if(fileName.substring(fileName.length() - 3).equals(".zip")) {
                ZipInputStream zipInputStream = new ZipInputStream(csvFileStream);
                zipInputStream.getNextEntry();
                inputStreamReader = new InputStreamReader(zipInputStream);
            } else {
                inputStreamReader = new InputStreamReader(csvFileStream);
            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.lines()
                    .skip(1)
                    .map(Exercise::parse)
                    .forEach(exerciseRepository::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
