package io.swagger.database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUser, String> {

    MongoUser findById(String id);
    MongoUser findByEmail(String email);

}
