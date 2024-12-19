package com.example.employeeManagementSystem.repository;

import com.example.employeeManagementSystem.entity.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatabaseSequenceRepository extends MongoRepository<DatabaseSequence, Long> {

}
