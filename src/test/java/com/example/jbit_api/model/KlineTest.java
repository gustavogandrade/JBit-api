package com.example.jbit_api.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.jbit_api.repository.KlineRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import jakarta.persistence.EntityManager;

@DataJpaTest
class KlineRepositoryTest {

    @Autowired
    private KlineRepository klineRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void savesAndFindsKline() {
        Kline kline = new Kline();
        kline.setOpenTime(LocalDateTime.of(2026, 10, 29, 12, 0));
        kline.setOpen(new BigDecimal("67000.12345678"));
        kline.setHigh(new BigDecimal("67500.00000000"));
        kline.setLow(new BigDecimal("66900.00000000"));
        kline.setClose(new BigDecimal("67250.50000000"));
        kline.setVolume(new BigDecimal("123.45600000"));

        Kline saved = klineRepository.save(kline);

        // Force the INSERT to run and clear the persistence context so the
        // next lookup really goes back to the database instead of the cache.
        entityManager.flush();
        entityManager.clear();

        Optional<Kline> found = klineRepository.findById(saved.getId());

        assertThat(found).isPresent();
        Kline k = found.get();
        assertThat(k.getOpenTime()).isEqualTo(LocalDateTime.of(2026, 10, 29, 12, 0));
        assertThat(k.getOpen()).isEqualByComparingTo("67000.12345678");
        assertThat(k.getHigh()).isEqualByComparingTo("67500.00000000");
        assertThat(k.getLow()).isEqualByComparingTo("66900.00000000");
        assertThat(k.getClose()).isEqualByComparingTo("67250.50000000");
        assertThat(k.getVolume()).isEqualByComparingTo("123.45600000");
    }
}