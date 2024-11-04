package lotto.controller;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseControllerTest {

    @DisplayName("입금한 금액에 걸맞는 로또를 구입한다.")
    @Test
    void test() {
        // given
        LottoPurchaseController controller = new LottoPurchaseController();

        // when
        Lottos lottos = controller.purchaseLottos(3000);

        // then
        assertThat(lottos.getLottos()).hasSize(3);
    }
}