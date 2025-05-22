package com.renan.javaspring.apiScreenSound;

import com.renan.javaspring.apiScreenSound.Main.MainSound;
import com.renan.javaspring.apiScreenSound.repositorySound.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // <- Adicione isso!
public class SoundspringApplication implements CommandLineRunner {

    @Autowired
    private ArtistaRepository artistaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SoundspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MainSound mainSound = new MainSound(artistaRepository);
        mainSound.exibeMenu();
    }
}
