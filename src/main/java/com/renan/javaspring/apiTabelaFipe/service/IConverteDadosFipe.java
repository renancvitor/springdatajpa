package com.renan.javaspring.apiTabelaFipe.service;

public interface IConverteDadosFipe {

    <T> T obterDadosFipe(String json, Class<T> tClass);
}
