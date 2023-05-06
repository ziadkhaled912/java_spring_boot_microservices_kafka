package com.ziadDev.app.controllers;

import com.ziadDev.app.models.Offer;
import com.ziadDev.app.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OfferController {

    @Autowired
    private OfferService offerService;
    @GetMapping("/offers")
    public ResponseEntity<List<Offer>> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/offer/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable() int id) {
        return offerService.getOfferById(id);
    }
}
