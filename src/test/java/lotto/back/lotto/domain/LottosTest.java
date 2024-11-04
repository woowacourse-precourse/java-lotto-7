package lotto.back.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.back.lotto.config.LottoConfig;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 구입_금액_예외() {
        // given
        int price = LottoConfig.PRICE.get() / 10;

        // when, then
        assertThatThrownBy(() -> Lottos.generateRandomLottos(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}