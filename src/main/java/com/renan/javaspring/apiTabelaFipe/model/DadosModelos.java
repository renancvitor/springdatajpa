package com.renan.javaspring.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(@JsonAlias("modelos") List<Modelo> modelos,
                           @JsonAlias("anos") List<Ano> ano) {
}
