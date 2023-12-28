package fitnesstrackerapplication.core.service;

import fitnesstrackerapplication.core.exceptions.repository.ResourceNotFoundException;
import fitnesstrackerapplication.core.model.UserProgress;
import fitnesstrackerapplication.core.repository.UserProgressRepository;
import fitnesstrackerapplication.rest.dto.UserProgressDTO;
import fitnesstrackerapplication.rest.dto.UserProgressRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProgressService {

    private final UserProgressRepository userProgressRepository;

    public UserProgressService(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    public List<UserProgressDTO> getUserProgressList() {
        List<UserProgress> userProgressList = userProgressRepository.findAll();
        return userProgressList.stream()
                .map(UserProgressDTO::new)
                .collect(Collectors.toList());
    }

    public UserProgressDTO getUserProgressById(String id) {
        Optional<UserProgress> userProgress = userProgressRepository.findById(id);
        if (userProgress.isEmpty()) {
            throw new ResourceNotFoundException("User progress with the given ID does not exist.");
        }
        return new UserProgressDTO(userProgress.get());
    }



    public UserProgressDTO addUserProgress(UserProgressRequestDTO payload) {
        UserProgress userProgress = userProgressRepository.save(payload.toEntity());
        return new UserProgressDTO(userProgress);
    }

    public UserProgressDTO updateUserProgress(String id, UserProgressRequestDTO payload) {
        Optional<UserProgress> userProgress = userProgressRepository.findById(id);
        if (userProgress.isEmpty()) {
            throw new ResourceNotFoundException("User progress with the given ID does not exist.");
        }
        UserProgress updatedUserProgress = payload.toEntity();
        updatedUserProgress.setId(userProgress.get().getId());
        updatedUserProgress = userProgressRepository.save(updatedUserProgress);
        return new UserProgressDTO(updatedUserProgress);
    }

    public void deleteUserProgress(String id) {
        Optional<UserProgress> userProgress = userProgressRepository.findById(id);
        userProgress.ifPresent(userProgressRepository::delete);
    }
}
