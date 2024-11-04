package lotto.domain;

import lotto.constant.NumberConstant;
import lotto.util.NumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.NumberConstant.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @DisplayName("구입 금액에 해당하는 만큼의 로또를 발행한다.")
    @Test
    void 로또_발행_테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        int purchaseLottoPrice = LOTTO_PRICE * 8;
        PurchaseMoney purchaseMoney = new PurchaseMoney(purchaseLottoPrice);
        LottoMachine lottoMachine = new LottoMachine(numberGenerator, purchaseMoney);

        Lottos lottos = lottoMachine.createLottos();
        List<Lotto> result = lottos.getLottos();
        Assertions.assertThat(result.size()).isEqualTo(purchaseLottoPrice / LOTTO_PRICE);
    }
}