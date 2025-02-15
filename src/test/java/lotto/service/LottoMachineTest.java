package lotto.service;

import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    @DisplayName("구입 금액에 따라 로또 번호를 생성")
    @Test
    void 로또번호_생성(){
        PurchaseAmount purchaseAmount = new PurchaseAmount(5000);
        List<Lotto> lottos=new ArrayList<>();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount,lottos);

        List<Lotto> result=lottoMachine.getLottos();

        assertThat(result.size()).isEqualTo(5);

        for (Lotto lotto : result) {
            assertThat(lotto.getNumbers().size()).isEqualTo(6);
            assertThat(lotto.getNumbers()).isSorted();
        }
    }
}