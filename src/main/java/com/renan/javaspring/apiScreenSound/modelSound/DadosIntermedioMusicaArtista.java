package com.renan.javaspring.apiScreenSound.modelSound;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosIntermedioMusicaArtista(@JsonAlias("data") List<DadosMusica> musicas) {
}
