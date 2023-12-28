package fitnesstrackerapplication.rest.controllers;

import fitnesstrackerapplication.core.service.UserProgressService;
import fitnesstrackerapplication.rest.dto.UserProgressDTO;
import fitnesstrackerapplication.rest.dto.UserProgressRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-progress")
public class UserProgressController {

    private final UserProgressService userProgressService;

    public UserProgressController(UserProgressService userProgressService) {
        this.userProgressService = userProgressService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "")
    @PreAuthorize("hasAuthority('MEMBER')")
    public ResponseEntity<List<UserProgressDTO>> getUserProgressList() {
        List<UserProgressDTO> userProgressList = userProgressService.getUserProgressList();
        return new ResponseEntity<>(userProgressList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @PreAuthorize("hasAuthority('MEMBER')")
    public ResponseEntity<UserProgressDTO> getUserProgressById(@PathVariable String id) {
        UserProgressDTO userProgress = userProgressService.getUserProgressById(id);
        return new ResponseEntity<>(userProgress, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "")
    @PreAuthorize("hasAuthority('MEMBER')")
    public ResponseEntity<UserProgressDTO> addUserProgress(@RequestBody UserProgressRequestDTO payload) {
        UserProgressDTO userProgress = userProgressService.addUserProgress(payload);
        return new ResponseEntity<>(userProgress, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAuthority('MEMBER')")
    public ResponseEntity<UserProgressDTO> updateUserProgress(
            @PathVariable String id,
            @RequestBody UserProgressRequestDTO payload
    ) {
        UserProgressDTO updatedUserProgress = userProgressService.updateUserProgress(id, payload);
        return new ResponseEntity<>(updatedUserProgress, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAuthority('MEMBER')")
    public ResponseEntity<Void> deleteUserProgress(@PathVariable String id) {
        userProgressService.deleteUserProgress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
