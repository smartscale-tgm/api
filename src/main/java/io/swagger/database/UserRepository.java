package io.swagger.database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUser, String> {

    MongoUser findByEmail(String email);

}
