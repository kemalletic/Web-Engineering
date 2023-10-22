package fitnesstrackerapplication.rest.controllers;

import fitnesstrackerapplication.core.model.Machines;
import fitnesstrackerapplication.core.service.MachinesService;
import fitnesstrackerapplication.core.service.UserService;
import fitnesstrackerapplication.rest.dto.MachinesRequestDTO;
import fitnesstrackerapplication.rest.dto.UserDTO;
import fitnesstrackerapplication.rest.dto.UserRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.metal.MetalScrollBarUI;
import java.util.List;

@RestController
@RequestMapping("api/machines")
public class MachinesControllers {

    private final MachinesService machinesService;

    public MachinesControllers(MachinesService machinesService) {
        this.machinesService = machinesService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Machines>> getMachines() {
        return ResponseEntity.ok(machinesService.getMachines());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<Machines> register(@RequestBody MachinesRequestDTO machines) {
        return ResponseEntity.ok(machinesService.addMachines(machines));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Machines> getMachinesByID(@PathVariable String id) {
        return ResponseEntity.ok(machinesService.getMachinesByID(id));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Machines> updateMachines(@PathVariable String id, @RequestBody MachinesRequestDTO user) {
        return ResponseEntity.ok(machinesService.updateMachines(id, user));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Void> deleteMachines(@PathVariable String id) {
        machinesService.deleteMachines(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

