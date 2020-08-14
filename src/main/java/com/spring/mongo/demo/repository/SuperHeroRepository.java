package com.spring.mongo.demo.repository;

import com.spring.mongo.demo.model.SuperHero;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SuperHeroRepository extends MongoRepository<SuperHero, String> {

}
