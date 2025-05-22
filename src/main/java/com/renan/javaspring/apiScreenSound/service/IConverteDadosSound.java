package com.renan.javaspring.apiScreenSound.service;

public interface IConverteDadosSound {
    <T> T obterDadosSound(String json, Class<T> classe);
}
