package com.ziadDev.app.repository;

import com.ziadDev.app.models.OfferItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferItemRepository extends JpaRepository<OfferItem, Integer> {
}
