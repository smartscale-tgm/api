package io.swagger.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StepsRepository extends MongoRepository<MongoSteps, String> {

    @Query(value="{user: ?0}")
    Page<MongoSteps> getStepsByPage(String user, Pageable pageable);

}