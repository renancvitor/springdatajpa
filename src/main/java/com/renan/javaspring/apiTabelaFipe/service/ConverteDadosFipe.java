package com.renan.javaspring.apiTabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteDadosFipe implements IConverteDadosFipe {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDadosFipe(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> obterLista(String json, Class<T> tClass) {
        try {
            return mapper.readValue(
                    json,
                    mapper.getTypeFactory().constructCollectionType(List.class, tClass)
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter lista de dados: " + e.getMessage(), e);
        }
    }
}
