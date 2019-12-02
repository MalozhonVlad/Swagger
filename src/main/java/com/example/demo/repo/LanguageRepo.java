package com.example.demo.repo;

import com.example.demo.domain.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {
}
