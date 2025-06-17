package com.naukri.database_api.controllers;

import com.naukri.database_api.models.ApplicationForm;
import com.naukri.database_api.repository.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/application")
public class ApplicationFormController {

    ApplicationFormRepository applicationFormRepository;

    @Autowired
    public ApplicationFormController(ApplicationFormRepository appRepo){
        this.applicationFormRepository=appRepo;
    }

    @PostMapping("/save")
    public ResponseEntity saveApplication(@RequestBody ApplicationForm applicationForm){
        applicationFormRepository.save(applicationForm);
        return new ResponseEntity(applicationForm, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getApplication(@PathVariable UUID id){
        ApplicationForm applicationForm=applicationFormRepository.findById(id).orElse(null);
        return new ResponseEntity(applicationForm,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateApplication(@RequestBody ApplicationForm applicationForm){
        applicationFormRepository.save(applicationForm);
        return new ResponseEntity(applicationForm, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteApplication(@PathVariable UUID id){
        applicationFormRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
