package lotto;

import lotto.model.LottoMachine;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 구입_금액에_맞게_로또를_발급() {
        int purchaseAmount = 5000;
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);

        assertThat(lottos.getLottos().size()).isEqualTo(purchaseAmount / Constant.LOTTO_PRICE);
    }

    @Test
    void 로또_번호_범위_확인() {
        int purchaseAmount = 10000;
        Lottos lottos = lottoMachine.issueLottos(purchaseAmount);

        lottos.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers())
                        .allMatch(num -> num >= Constant.LOTTO_START_NUM && num <= Constant.LOTTO_END_NUM)
        );
    }
}
