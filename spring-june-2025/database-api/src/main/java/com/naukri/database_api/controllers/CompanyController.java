package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Company;
import com.naukri.database_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/company")
public class CompanyController {

    CompanyRepository companyRepo;

    @Autowired
    public void CompanyRepo(CompanyRepository companyrepository){ this.companyRepo = companyrepository;
    }

    @PostMapping("/save")
    public ResponseEntity createCompany(@RequestBody Company company){
        companyRepo.save(company);
        return new ResponseEntity(company,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompany(@PathVariable UUID id){
        Company company=companyRepo.findById(id).orElse(null);
        return new ResponseEntity(company,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateCompany(@RequestBody Company company){
        companyRepo.save(company);
        return new ResponseEntity(company,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany(@PathVariable UUID id){
        companyRepo.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
