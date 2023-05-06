package com.ziadDev.app.services;

import com.ziadDev.app.models.OfferItem;
import com.ziadDev.app.repository.OfferItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferItemServices {
    @Autowired
    private OfferItemRepository offerItemRepository;

    public OfferItem addItem(OfferItem item) {
        return offerItemRepository.save(item);
    }
}
