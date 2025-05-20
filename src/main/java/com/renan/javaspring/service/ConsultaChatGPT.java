//package com.renan.javaspring.service;
//
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.service.OpenAiService;
//
//public class ConsultaChatGPT {
//    public static String obterTraducao(String texto) {
//        OpenAiService service = new OpenAiService
//                ("colar chave API OpenAI aqui");
//
//        CompletionRequest requisicao = CompletionRequest.builder()
//                .model("gpt-3.5-turbo-instruct")
//                .prompt("traduza para o português o texto: " + texto)
//                .maxTokens(1000)
//                .temperature(0.7)
//                .build();
//
//        var resposta = service.createCompletion(requisicao);
//        return resposta.getChoices().get(0).getText();
//    }
//}
//

//************************************

//package com.renan.javaspring.service;
//
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//import org.json.JSONObject;
//
//public class ConsultaChatGPT { // Usando JSONject
//    public static String obterTraducao(String texto) {
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//
//            String url = UriComponentsBuilder.fromHttpUrl("https://lingva.ml/api/v1/en/pt/" + texto)
//                    .build()
//                    .toUriString();
//
//            String resposta = restTemplate.getForObject(url, String.class);
//            JSONObject json = new JSONObject(resposta);
//
//            return json.getString("translation");
//        } catch (Exception e) {
//            e.printStackTrace();
//            // fallback: retorna o texto original se der erro
//            return texto;
//        }
//    }
//}

//******************************************

package com.renan.javaspring.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ConsultaChatGPT { // Usando Jackson
    // Teste 02
    public static String obterTraducao(String texto) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = UriComponentsBuilder
                    .fromHttpUrl("https://lingva.ml/api/v1/en/pt/" + texto)
                    .build()
                    .toUriString();

            String resposta = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(resposta);

            return jsonNode.get("translation").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return texto;
        }
    }
}
