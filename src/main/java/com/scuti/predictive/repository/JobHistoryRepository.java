package com.scuti.predictive.repository;

import com.mongodb.MongoClient;
import org.bson.Document;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


@Repository
public class JobHistoryRepository {

    @Autowired
    private MongoClient mongo;

    public void add(Map<String, Object> keys) {
        // TODO: make configurable / use repository ?
        // TODO: set expire TTL based on 'ts' field (ie. 7 days)
        mongo.getDatabase("jobs-demo").getCollection("job_history")
                .insertOne(new Document(keys));
    }

}
