package com.challeng_1.literalura.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String fechaNacimiento;

    private String fechaFallecimiento;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

}

