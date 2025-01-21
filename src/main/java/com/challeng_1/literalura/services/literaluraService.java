package com.challeng_1.literalura.services;

import com.challeng_1.literalura.api.consumoApi;
import com.challeng_1.literalura.api.convertData;
import com.challeng_1.literalura.model.data;
import com.challeng_1.literalura.model.infoLibros;
import com.challeng_1.literalura.repositories.LibroRepository;
import com.challeng_1.literalura.repositories.AutorRepository;
import com.challeng_1.literalura.entity.Libro;
import com.challeng_1.literalura.entity.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class literaluraService {

    @Autowired
    private consumoApi api;

    @Autowired
    private convertData convert;

    // private final consumoApi api = new consumoApi();
    // private final convertData convert = new convertData();

    @Autowired
    private LibroRepository libroRepository;
    // private final LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;
    // private final AutorRepository autorRepository;

    public Libro buscarYGuardarLibro(String titulo) {
        // api.obtenerDatos();
        String jsonResponse = api.obtenerDatos(titulo);
        data datos = convert.obtenerDatos(jsonResponse, data.class);

        Optional<infoLibros> libroBuscado = datos.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(titulo.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            infoLibros info = libroBuscado.get();

            Libro libro = new Libro();
            libro.setTitulo(info.titulo());

            if (info.idioma() != null && !info.idioma().isEmpty()) {
                libro.setIdioma(String.join(", ", info.idioma()));
            }
            libro.setNDescargas(info.nDescargas());

            List<Autor> autores = new ArrayList<>();
            for (var autorInfo : info.autor()) {
                Autor autor = new Autor();
                autor.setNombre(autorInfo.nombre());
                autor.setFechaNacimiento(autorInfo.fechaNacimiento());
                autor.setFechaFallecimiento(autorInfo.fechaFallecimiento());
                autores.add(autor);
            }

            libro.setAutores(autores);
            libroRepository.save(libro);

            return libro;

        } else {
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
