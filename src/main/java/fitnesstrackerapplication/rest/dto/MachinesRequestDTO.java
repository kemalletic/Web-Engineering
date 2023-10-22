package fitnesstrackerapplication.rest.dto;

import fitnesstrackerapplication.core.model.Machines;

public class MachinesRequestDTO {

    private String name;
    private String description;
    private String category;
    private String manufacturer;
    public MachinesRequestDTO(Machines machines) {
        this.name = machines.getName();
        this.description = machines.getDescription();
        this.category = machines.getCategory();
        this.manufacturer = machines.getManufacturer();
    }

    public MachinesRequestDTO(){}
    public Machines toEntity(){
        Machines machines=new Machines();
        machines.setName(name);
        machines.setDescription(description);
        machines.setCategory(category);
        machines.setManufacturer(manufacturer);
        return machines;
    }




    // Getters and setters for all properties



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }




}

