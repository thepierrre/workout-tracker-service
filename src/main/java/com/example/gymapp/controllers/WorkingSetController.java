package com.example.gymapp.controllers;

import com.example.gymapp.domain.dto.WorkingSetDto;
import com.example.gymapp.mappers.impl.WorkingSetMapper;
import com.example.gymapp.services.WorkingSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workouts/{workoutId}/exercise-instances/{exerciseInstanceId}/sets")
public class WorkingSetController {

    @Autowired
    WorkingSetService workingSetService;

    public List<WorkingSetDto> findAll() {
        return workingSetService.findAll();
    }

    public ResponseEntity<WorkingSetDto> createWorkingSet(@RequestBody WorkingSetDto workingSetDto) {
        WorkingSetDto createdWorkingSet = workingSetService.createWorkingSet(workingSetDto);
        return new ResponseEntity<>(createdWorkingSet, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{setId}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        workingSetService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
