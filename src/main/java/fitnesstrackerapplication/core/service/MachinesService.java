package fitnesstrackerapplication.core.service;

import fitnesstrackerapplication.core.api.mailsender.MailSender;
import fitnesstrackerapplication.core.exceptions.repository.ResourceNotFoundException;
import fitnesstrackerapplication.core.model.Machines;
import fitnesstrackerapplication.core.model.User;
import fitnesstrackerapplication.core.repository.MachinesRepository;
import fitnesstrackerapplication.core.repository.UserRepository;
import fitnesstrackerapplication.rest.dto.MachinesRequestDTO;
import fitnesstrackerapplication.rest.dto.UserDTO;
import fitnesstrackerapplication.rest.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class MachinesService {
    private final MachinesRepository machinesRepository;





    public MachinesService(MachinesRepository machinesRepository) {
        this.machinesRepository = machinesRepository;
    }

    public List<Machines> getMachines() {
        List<Machines> machines = machinesRepository.findAll();
        // List<Machines> users = machinesRepository.findAllCustom();

        return machines;

    }

    public Machines getMachinesByID(String id) {
        Optional<Machines> machines = machinesRepository.findById(id);
        if (machines.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        return machines.get();
    }

    public Machines addMachines(MachinesRequestDTO payload) {
        Machines machines = machinesRepository.save(payload.toEntity());
        return machines;
    }

    public Machines updateMachines(String id, MachinesRequestDTO payload) {
        Optional<Machines> machines = machinesRepository.findById(id);
        if (machines.isEmpty()) {
            throw new ResourceNotFoundException("The user with the given ID does not exist.");
        }
        Machines updatedMachines = payload.toEntity();
        updatedMachines.setId(machines.get().getId());
        updatedMachines = machinesRepository.save(updatedMachines);
        return updatedMachines;
    }

    public void deleteMachines(String id) {
        Optional<Machines> machines = machinesRepository.findById(id);
        machines.ifPresent(machinesRepository::delete);
    }


}


