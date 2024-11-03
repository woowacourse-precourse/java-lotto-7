package lotto.domain.factory;

import static lotto.config.GameConstant.PRICE_OF_LOTTO;
import static lotto.domain.factory.LottoFactory.generateLotto;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import lotto.domain.Purchase;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    void 로또_발급_성공() {
        Money money = new Purchase(PRICE_OF_LOTTO*5);

        assertThat(generateLotto(money)).hasSize(5);
    }
}