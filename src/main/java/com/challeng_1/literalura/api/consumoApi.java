package com.challeng_1.literalura.api;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class consumoApi {
    
    public String obtenerDatos(String busqueda){

        URI direccion = URI.create("https://gutendex.com/books/?search=" + busqueda);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println("Error al consumir la API: " + e.getMessage());
            return null;
        }

        
    }
}
