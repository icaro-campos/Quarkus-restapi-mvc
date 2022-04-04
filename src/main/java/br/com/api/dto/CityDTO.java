package br.com.api.dto;

import br.com.api.entities.City;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CityDTO {

    @Size(min=3, max=30)
    @NotBlank
    private String name;
    private StateDTO state;

    public CityDTO(String name) {
        this.name = name;
    }

    public CityDTO(City entity) {
        name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

}
