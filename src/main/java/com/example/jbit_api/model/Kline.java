package com.example.jbit_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "btc_klines")
public class Kline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "open_time")
    private LocalDateTime openTime;

    @Column(precision = 20, scale = 8)
    private BigDecimal open;

    @Column(precision = 20, scale = 8)
    private BigDecimal high;

    @Column(precision = 20, scale = 8)
    private BigDecimal low;

    @Column(precision = 20, scale = 8)
    private BigDecimal close;

    @Column(precision = 20, scale = 8)
    private BigDecimal volume;

    protected Kline() {
    }

}
