package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosFactoryTest {
    @DisplayName("구입 금액 만큼 로또를 발행한다.")
    @Test
    void 구입_금액_만큼_로또를_발행한다() {
        // given
        final int LOTTO_PRICE = 1000;
        Cost cost = new Cost("5000");
        int expectedLottoCount = cost.getValue() / LOTTO_PRICE;

        LottoFactory lottoFactory = new LottoFactory();

        // when
        Lottos lottos = lottoFactory.generateLottos(cost);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(expectedLottoCount);
    }
}