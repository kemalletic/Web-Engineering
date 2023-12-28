package fitnesstrackerapplication.core.repository;

import fitnesstrackerapplication.core.model.User;
import fitnesstrackerapplication.core.model.enums.UserType;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    @Query(value="{$or:[{email: '?0'}, {username: '?0'}]}")
    Optional<User> findByUsernameOrEmail(String username);


}
