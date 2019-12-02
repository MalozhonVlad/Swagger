package com.example.demo.controller;

import com.example.demo.domain.Language;
import com.example.demo.repo.LanguageRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "language resources", description = "crud operations")
public class LanguageController {

    private LanguageRepo languageRepo;

    @GetMapping
    @ApiOperation(value = "show all languages",response = Iterable.class)
    public Iterable<Language> getAllLanguage() {
        return languageRepo.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "show language by id",response = Language.class)
    public Language getLanguageById(@PathVariable("id") Long id) {
        return languageRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create language",response = Language.class)
    public Language createLanguage(@Valid @RequestBody Language language) {
        return languageRepo.save(language);
    }


}
