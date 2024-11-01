package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoAgencyTest {
    private LottoAgency lottoAgency;

    @BeforeEach
    void setUp() {
        this.lottoAgency = new LottoAgency();
    }

    @Test
    void 천원단위로_로또개수를_계산한다() {
        int count = lottoAgency.calculatePurchaseCount(3000);
        assertEquals(count, 3);
    }


}