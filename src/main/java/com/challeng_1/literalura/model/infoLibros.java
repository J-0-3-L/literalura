package com.challeng_1.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record infoLibros(
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<infoAutor> autor,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("download_count")  Double nDescargas

) {}

