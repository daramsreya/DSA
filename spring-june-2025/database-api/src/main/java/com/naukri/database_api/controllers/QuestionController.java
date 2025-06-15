package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Questions;
import com.naukri.database_api.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/question")
public class QuestionController {
    QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepo){
        this.questionRepository=questionRepo;
    }

    @PostMapping("/save")
    public ResponseEntity saveQuestion(@RequestBody Questions question){
        questionRepository.save(question);
        return new ResponseEntity(question, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuestion(@PathVariable UUID id){
        Questions question=questionRepository.findById(id).orElse(null);
        return new ResponseEntity(question,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateQuestion(@RequestBody Questions question){
        questionRepository.save(question);
        return new ResponseEntity(question, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletQuestion(@PathVariable UUID id){
        questionRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
