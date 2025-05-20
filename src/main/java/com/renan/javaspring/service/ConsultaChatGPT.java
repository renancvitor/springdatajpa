package com.renan.javaspring.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService
                ("sk-proj-PhKqwfrRtqSF1QsqIsfNDLlnfZGo5q8yzSqIL5QK5kGK1NsYIy" +
                        "CELeyxVeTUGusPLu4UsNqanLT3BlbkFJVYWI6PccKGvDXCDBJ120RTwpiv" +
                        "Ya0lJ8C5cTuMuOp-GRmDoNUTLyjZ92iEOHtrAG_FikhIKyUA");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
