package io.thgroupproject.basecampnomination.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.text.ParseException;


import java.util.UUID;
@Data

public class UEstudents {
    public UUID id;

    @NotNull
    @Size(min = 1, max= 20)
    public String name;
    @NotNull
    @Size(min = 1, max = 20)
    public String district;
    @NotNull
    public String email;

    public UEstudents(UUID id, String name, String district, String email) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.email = email;
    }
    public String[] paragraphs(String text) {
        return text.split("\n");
    }
}
