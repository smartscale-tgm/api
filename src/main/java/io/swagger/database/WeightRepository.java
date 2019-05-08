package io.swagger.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeightRepository extends MongoRepository<MongoWeight, String> {

    List<MongoWeight> findByUserOrderByTimestampDesc(String user);

}