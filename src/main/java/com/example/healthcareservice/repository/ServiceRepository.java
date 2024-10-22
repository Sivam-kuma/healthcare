package com.example.healthcareservice.repository;

import com.example.healthcareservice.model.HealthcareService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
ServiceRepository extends MongoRepository<HealthcareService, String> {
}
