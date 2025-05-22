package com.renan.javaspring.apiScreenSound;

import com.renan.javaspring.apiScreenSound.Main.MainSound;
import com.renan.javaspring.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class SoundspringApplication implements CommandLineRunner {

    @Autowired
    private SerieRepository repositorySound;

    public static void main(String[] args) {
        SpringApplication.run(SoundspringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MainSound mainSound = new MainSound(repositorySound);
        mainSound.exibeMenu();
    }
}
