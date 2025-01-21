package com.challeng_1.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired
    private main main;

    @Override
    public void run(String... args) throws Exception {
        main.muestraElMenu();
    }
}
