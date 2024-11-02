package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("생성된 로또 개수가 예상 개수와 같은지 확인하는 테스트")
    @Test
    void buyLottos_GeneratesCorrectNumberOfLottos() {
        int purchaseAmount = 5000;
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount, lottoNumberGenerator);

        List<Lotto> lottos = lottoMachine.buyLottos();
        assertThat(lottos).hasSize(5000 / LOTTO_PRICE);
    }
}