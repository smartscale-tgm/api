package io.swagger.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StepsRepository extends MongoRepository<MongoSteps, String> {

    List<MongoSteps> findByUserOrderByTimestampDesc(String user);

}