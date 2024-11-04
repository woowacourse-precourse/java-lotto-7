package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.PurchasedLottos;
import lotto.util.NumberGenerate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final NumberGenerate numberGenerate = new LottoGeneratorTest();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerate);

    @Test
    void 랜덤_값_테스트() {
        // given
        List<Integer> expect = numberGenerate.randomGenerateInRange(Lotto.LOTTO_NUM_START, Lotto.LOTTO_NUM_END, Lotto.LOTTO_NUM_SIZE);
        LottoMoney lottoMoney = new LottoMoney(1000);

        // when
        PurchasedLottos purchasedLottos = lottoMachine.issueLotto(lottoMoney);
        List<Lotto> lottos = purchasedLottos.lottos();

        // then
        for (Lotto lotto : lottos) {
            Assertions.assertThat(lotto.numbers()).isEqualTo(expect);
        }
    }
}