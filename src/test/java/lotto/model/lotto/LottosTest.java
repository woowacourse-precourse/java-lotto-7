package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("주어진 개수의 로또를 생성한다.")
    @Test
    void 로또를_주어진_개수만큼_생성한다() {
        int lottosCount = 5;
        Lottos lottos = Lottos.fromCount(lottosCount);
        assertThat(lottos.getLottos()).hasSize(lottosCount);
    }

    @DisplayName("각 로또 번호의 개수는 6개이다.")
    @Test
    void 로또의_번호_개수는_6개이다() {
        int lottosCount = 10;
        Lottos lottos = Lottos.fromCount(lottosCount);
        for (Lotto lotto : lottos.getLottos()) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @DisplayName("로또의 총 가격이 올바르게 계산된다.")
    @Test
    void 로또의_총_가격을_계산한다() {
        int lottosCount = 3;
        Lottos lottos = Lottos.fromCount(lottosCount);
        int expectedTotalPrice = lottosCount * Lotto.PRICE;

        assertThat(lottos.getTotalPrice()).isEqualTo(expectedTotalPrice);
    }
}
