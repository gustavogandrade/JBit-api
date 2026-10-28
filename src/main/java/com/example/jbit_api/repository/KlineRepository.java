package com.example.jbit_api.repository;

import com.example.jbit_api.model.Kline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlineRepository extends JpaRepository<Kline, Integer> {
}
