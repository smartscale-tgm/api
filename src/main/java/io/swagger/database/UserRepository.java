package io.swagger.database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserMongo, String> {

    UserMongo findByEmail(String email);

}
