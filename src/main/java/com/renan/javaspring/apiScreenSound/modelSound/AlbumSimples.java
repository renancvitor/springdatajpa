package com.renan.javaspring.apiScreenSound.modelSound;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AlbumSimples(
        @JsonAlias("title") String titulo
) {}
