package com.ziadDev.app.services;

import com.ziadDev.app.models.Offer;
import com.ziadDev.app.models.OfferItem;
import com.ziadDev.app.models.OfferMessage;
import com.ziadDev.app.repository.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferItemServices offerItemServices;

    private final Logger logger =
            LoggerFactory.getLogger(OfferService.class);

    public ResponseEntity<List<Offer>> getAllOffers() {
        return ResponseEntity.ok(offerRepository.findAll());
    }

    public ResponseEntity<Offer> getOfferById(int id) {
        Optional<Offer> offer = offerRepository.findById(id);
        return offer.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity(HttpStatusCode.valueOf(404)));
    }

    @KafkaListener(topics = "offer",
    groupId = "group_id",
    containerFactory = "userFactory")
    public void consume(OfferMessage message) {
        logger.info("Message recieved -> [{}]", message);
        OfferItem item = offerItemServices.addItem(OfferItem.builder()
                        .type(message.getItem())
                        .quantity(message.getQuantity())
                .build());
        Offer offer = Offer.builder()
                .percentage(message.getPercentage())
                .valid(true)
                .item(item)
                .build();
        offerRepository.save(offer);
    }
}
