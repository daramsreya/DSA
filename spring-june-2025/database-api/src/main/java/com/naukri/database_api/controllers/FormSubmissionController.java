package com.naukri.database_api.controllers;

import com.naukri.database_api.models.FormSubmission;
import com.naukri.database_api.repository.FormSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/submission")
public class FormSubmissionController {

    FormSubmissionRepository formSubmissionRepository;

    @Autowired
    public FormSubmissionController(FormSubmissionRepository submissionRepo){
        this.formSubmissionRepository = submissionRepo;
    }

    @PostMapping("/save")
    public ResponseEntity saveSubmission(@RequestBody FormSubmission formSubmission){
        formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmission, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSubmission(@PathVariable UUID id){
        FormSubmission formSubmission=formSubmissionRepository.findById(id).orElse(null);
        return new ResponseEntity(formSubmission,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateSubmission(@RequestBody FormSubmission formSubmission){
        formSubmissionRepository.save(formSubmission);
        return new ResponseEntity(formSubmission, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteSubmission(@PathVariable UUID id){
        formSubmissionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
