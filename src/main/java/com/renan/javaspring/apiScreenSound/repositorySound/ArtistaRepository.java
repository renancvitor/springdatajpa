package com.renan.javaspring.apiScreenSound.repositorySound;

import com.renan.javaspring.apiScreenSound.modelSound.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nome);
}
