package com.example.chatbot.model;

import lombok.Data;
import java.util.Map;

@Data
public class WebhookRequest {
    private Map<String, Object> entry;
    private Map<String, Object> changes;
}
