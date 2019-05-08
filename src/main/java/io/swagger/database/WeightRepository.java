package io.swagger.database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WeightRepository extends MongoRepository<MongoWeight, String> {

    @Query(value="{user: ?0}")
    Page<MongoWeight> getStepsByPage(String user, Pageable pageable);

}