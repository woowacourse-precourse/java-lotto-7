package lotto.model.money;

import lotto.common.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Error.INVALID_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 2, 0})
    void 로또_금액으로_나누어_떨어지지_않으면_예외가_발생한다(int money) {
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_MONEY.getMessage());
    }

    @Test
    void 금액에_맞는_로또_개수를_저장한다() {
        Money money = Money.from(Rule.LOTTO_PRICE.getNumber() * 2);
        assertThat(money.getCount()).isEqualTo(2);
    }
}