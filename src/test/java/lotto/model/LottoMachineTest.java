package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 구입_금액의_1000원당_로또_1개_발행() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        int purchaseAmount = 20000;
        int lottoCount = 20;

        // when
        lottoMachine.purchaseLottos(purchaseAmount);

        // then
        Assertions.assertThat(lottoMachine.getLottos().size()).isEqualTo(lottoCount);
    }
}
