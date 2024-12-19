package com.example.employeeManagementSystem.service;

import com.example.employeeManagementSystem.entity.DatabaseSequence;
import org.modelmapper.internal.bytebuddy.matcher.ElementMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String sequenceName) {
        DatabaseSequence counter =  mongoOperations.findAndModify(query(where("_id").is(sequenceName)),
                new Update().inc("seq", 1L),options().returnNew(true).upsert(true),
        DatabaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }




}
