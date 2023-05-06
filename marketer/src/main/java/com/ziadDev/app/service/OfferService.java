package com.ziadDev.app.service;

import com.ziadDev.app.models.OfferMessage;
import com.ziadDev.app.payloads.OfferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    private KafkaTemplate<String, OfferMessage> kafkaTemplate;

    public OfferService(KafkaTemplate<String, OfferMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public ResponseEntity<OfferMessage> addOffer(OfferRequest request) {
        OfferMessage offer = OfferMessage.builder()
                .item(request.item())
                .percentage(request.percentage())
                .quantity(request.quantity())
                .build();
        kafkaTemplate.send("offer", offer);
        return ResponseEntity.ok(offer);
    }
}
