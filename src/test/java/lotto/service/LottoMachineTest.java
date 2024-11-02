package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Application;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 구매_개수만큼_로또를_발행한다() {
        String purchaseAmount = "2000";
        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);

        Lottos lottos = lottoMachine.issueLottos(lottoAmount);

        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }
}
