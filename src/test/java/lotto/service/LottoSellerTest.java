package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {
    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        this.lottoSeller = new LottoSeller();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 1100, 8800, 999000, 3330000, 9900})
    void 천원단위로_로또개수를_계산한다(int amount) {
        int count = lottoSeller.calculatePurchaseCount(amount);
        assertEquals(count, amount / 1000);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 99, 100, 1000})
    void 로또개수만큼_로또를_제공한다(int count) {
        List<Lotto> lotto = lottoSeller.provideLotto(count);
        assertThat(lotto.size()).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 1100, 8800, 999000, 3330000, 9900})
    void 요금대로_로또를_제공한다(int amount) {
        List<Lotto> lotto = lottoSeller.buyLotto(amount);
        assertEquals(lotto.size(), amount / 1000);
    }

}