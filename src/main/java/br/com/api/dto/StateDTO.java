package br.com.api.dto;

import br.com.api.entities.State;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StateDTO {

    private Long id;
    @Size(min=2, max=30)
    @NotBlank
    private String name;
    private String uf;

    public StateDTO(State entity){
        name = entity.getName();
    }

    public StateDTO(String name) {
        this.name = name;
    }

    public StateDTO(String name, Long id, String uf) {
        this.name = name;
        this.id = id;
        this.uf = uf;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getUf() {

        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
