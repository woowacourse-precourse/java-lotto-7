package lotto.domain.factory;

import static lotto.domain.factory.LottoFactory.generateLotto;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    void 로또_발급_성공() {
        Money money = new Money("5000");

        assertThat(generateLotto(money)).hasSize(5);
    }
}