package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {
    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        this.lottoSeller = new LottoSeller();
    }

    @Test
    void 천원단위로_로또개수를_계산한다() {
        int count = lottoSeller.calculatePurchaseCount(3000);
        assertEquals(count, 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 99, 100, 1000})
    void 로또개수만큼_로또를_제공한다(int count) {
        List<Lotto> lotto = lottoSeller.provideLotto(count);
        assertThat(lotto.size()).isEqualTo(count);
    }


}