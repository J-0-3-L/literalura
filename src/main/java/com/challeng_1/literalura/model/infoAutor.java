package com.challeng_1.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record infoAutor(
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") String fechaNacimiento,
    @JsonAlias("death_year") String fechaFallecimiento

) {}

