package com.challeng_1.literalura;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challeng_1.literalura.entity.Libro;
import com.challeng_1.literalura.services.literaluraService;

@Component
public class main {

    @Autowired
    private literaluraService service;
    
    public void muestraElMenu(){

        Scanner challeng = new Scanner(System.in);

        System.out.println("\n-------------------------------");
        System.out.println("\nBienvenido a LiterAlura:");

        System.out.println("1.- Buscar libro por titulo");
        System.out.println("2.- Listar libros registrados");
        System.out.println("3.- Listar autores registrados");
        System.out.println("4.- Listar libros por idioma");
        System.out.println("5.- Salir");

        System.out.println("\n-------------------------------");

        int opcion;

        do{
            System.out.println("\nElija la opcion a traves de su numero: ");
            opcion = challeng.nextInt();
            challeng.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = challeng.next();
                    // service.buscarYGuardarLibro(titulo);
                    Libro libroEncontrado = service.buscarYGuardarLibro(titulo);

                    System.out.println("\n-----------LIBRO ENCONTRADO-----------");
                    System.out.println("Título: " + libroEncontrado.getTitulo());
                    System.out.println("Idioma: " + libroEncontrado.getIdioma());
                    System.out.println("Número de descargas: " + libroEncontrado.getNDescargas());
                    System.out.println("Autores:");
                    libroEncontrado.getAutores().forEach(autor -> System.out.println(" - " + autor.getNombre()));
                    System.out.println("--------------------------------------");
                    break;
                case 2:
                    var libros = service.listarLibros();
                    System.out.println("Libros: ");
                    for(var l : libros){
                        System.out.println("- "+l.getTitulo());
                    }                    
                    break;
                case 3:
                    var autores= service.listarAutores();
                    System.out.println("Autores: ");
                    for(var a : autores){
                        System.out.println("- "+a.getNombre());
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el idioma (es, en, fr, pt): ");
                    String idioma = challeng.next();
                    service.listarLibrosPorIdioma(idioma).forEach(libro -> System.out.println(libro.getTitulo()));
                    break;
                case 5:
                    System.out.println("Saliendo ...");
                    System.out.println("Gracias por usar nuestro servicio");
                    break;
                default:
                    System.out.println("Opcion no valida. Intentalo otra vez");
                    break;
            }

        }while(opcion != 5);

        challeng.close();

    }
}
