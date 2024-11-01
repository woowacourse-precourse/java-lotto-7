package lotto.back.lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import lotto.back.lotto.config.LottoConfig;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 구입_금액_예외() {
        // given
        int price = LottoConfig.PRICE.get() / 10;
        UUID uuid = UUID.randomUUID();

        // when, then
        assertThatThrownBy(() -> Lottos.purchase(uuid, price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}