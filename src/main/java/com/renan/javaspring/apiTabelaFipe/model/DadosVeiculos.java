package com.renan.javaspring.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculos(@JsonAlias("TipoVeiculo") String tipoVeiculo,
                            @JsonAlias("Marca") String marca,
                            @JsonAlias("Modelo") String modelo,
                            @JsonAlias("AnoModelo") int anoModelo,
                            @JsonAlias("Valor") String valor,
                            @JsonAlias("CodigoFipe") String codigoFipe) {
}
