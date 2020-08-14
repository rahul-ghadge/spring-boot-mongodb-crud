package com.spring.mongo.demo.service.impl;

import com.spring.mongo.demo.model.SuperHero;
import com.spring.mongo.demo.repository.SuperHeroRepository;
import com.spring.mongo.demo.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroServiceImpl  implements SuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

    @Override
    public SuperHero findById(String id) {
        return repository.findById(id)
                .orElse(new SuperHero());
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public void delete(String id) {
        Optional<SuperHero> superHeroOptional = repository.findById(id);
        if (superHeroOptional.isPresent())
            repository.delete(superHeroOptional.get());
    }
}
