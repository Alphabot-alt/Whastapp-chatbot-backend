package com.example.chatbot.controller;

import com.example.chatbot.model.WebhookRequest;
import com.example.chatbot.service.WhatsAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WhatsAppController {

    private final WhatsAppService whatsAppService;

    public WhatsAppController(WhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @GetMapping
    public ResponseEntity<String> verify(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String token) {
        if ("subscribe".equals(mode) && "YOUR_VERIFY_TOKEN".equals(token)) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.status(403).body("Verification failed");
    }

    @PostMapping
    public ResponseEntity<Void> receive(@RequestBody WebhookRequest request) {
        String from = "extracted_phone_number";
        String message = "extracted_message_body";
        whatsAppService.sendMessage(from, "Echo: " + message);
        return ResponseEntity.ok().build();
    }
}
