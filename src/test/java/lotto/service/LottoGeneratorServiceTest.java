package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoGeneratorServiceTest {
    private LottoGeneratorService lottoGeneratorService;

    @BeforeEach
    void setUp() {
        this.lottoGeneratorService = new LottoGeneratorService();
    }

    @Test
    void 범위_안의_6개의_숫자리스트_반환() {
        List<Integer> list = lottoGeneratorService.generateSixNumbers();
        assertEquals(6, list.size());
        for (Integer number : list) {
            assertTrue(number >= 1 && number <= 45);
        }
    }
}