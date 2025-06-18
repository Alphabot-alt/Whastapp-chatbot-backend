package com.example.chatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class WhatsAppService {

    @Value("${whatsapp.api.base-url}")
    private String baseUrl;

    @Value("${whatsapp.api.phone-number-id}")
    private String phoneNumberId;

    @Value("${whatsapp.api.token}")
    private String token;

    private final RestTemplate restTemplate;

    public WhatsAppService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> sendMessage(String to, String message) {
        String url = String.format("%s%s/messages?access_token=%s", baseUrl, phoneNumberId, token);
        Map<String, Object> payload = Map.of(
            "messaging_product", "whatsapp",
            "to", to,
            "type", "text",
            "text", Map.of("body", message)
        );
        return restTemplate.postForObject(url, payload, Map.class);
    }
}
