package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Questions;
import com.naukri.database_api.models.Skill;
import com.naukri.database_api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/db/skill")
public class SkillController {

    SkillRepository skillRepository;

    @Autowired
    public SkillController(SkillRepository skillRepo){
        this.skillRepository=skillRepo;
    }

    @PostMapping("/save")
    public ResponseEntity saveSkill(@RequestBody Skill skill){
        skillRepository.save(skill);
        return new ResponseEntity(skill, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSkill(@PathVariable UUID id){
        Skill skill=skillRepository.findById(id).orElse(null);
        return new ResponseEntity(skill,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateSkill(@RequestBody Skill skill){
        skillRepository.save(skill);
        return new ResponseEntity(skill, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteSkill(@PathVariable UUID id){
        skillRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
