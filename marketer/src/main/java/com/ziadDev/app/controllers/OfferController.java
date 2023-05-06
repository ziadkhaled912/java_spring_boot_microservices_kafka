package com.ziadDev.app.controllers;

import com.ziadDev.app.models.OfferMessage;
import com.ziadDev.app.payloads.OfferRequest;
import com.ziadDev.app.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController()
@RequestMapping("api/v1")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/addOffer")
    public ResponseEntity<OfferMessage> addOffer(@RequestBody OfferRequest request) {
        return offerService.addOffer(request);
    }
}
