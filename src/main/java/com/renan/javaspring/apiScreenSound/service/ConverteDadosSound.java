package com.renan.javaspring.apiScreenSound.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDadosSound implements IConverteDadosSound {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDadosSound(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
