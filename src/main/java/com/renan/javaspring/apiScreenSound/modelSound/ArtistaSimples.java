package com.renan.javaspring.apiScreenSound.modelSound;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ArtistaSimples(
        @JsonAlias("name") String nome
) {}
