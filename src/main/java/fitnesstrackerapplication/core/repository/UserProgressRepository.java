package fitnesstrackerapplication.core.repository;

import fitnesstrackerapplication.core.model.User;
import fitnesstrackerapplication.core.model.UserProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends MongoRepository<UserProgress, String> {


}
