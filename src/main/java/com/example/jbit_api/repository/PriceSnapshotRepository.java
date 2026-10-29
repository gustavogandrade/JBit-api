package com.example.jbit_api.repository;

import com.example.jbit_api.model.PriceSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceSnapshotRepository extends JpaRepository<PriceSnapshot, Integer> {
}
