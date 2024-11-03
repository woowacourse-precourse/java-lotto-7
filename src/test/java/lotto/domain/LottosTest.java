package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("주어진 수량만큼 로또를 발행한다.")
    @Test
    public void 주어진_수량만큼_로또를_발행한다() {
        int lottoQuantity = 5;
        Lottos lottos = Lottos.of(lottoQuantity);

        assertEquals(lottoQuantity, lottos.getLottoCount());
    }
}