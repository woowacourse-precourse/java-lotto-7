package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1})
    @DisplayName("로또 구입 금액이 1000원이하면 예외가 발생한다.")
    void 로또_구입_금액이_1000원이하면_예외가_발생한다(final Integer money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MINIMUM_PURCHASE_AMOUNT_ERROR_MESSAGE);
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2001, 2450})
    void 로또_구입_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다(final Integer money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_DIVISIBILITY_ERROR_MESSAGE);
    }

    @DisplayName("로또 구입 금액을 알려준다.")
    @Test
    void 로또_구입_금액을_알려준다() {
        Money money = new Money(3000);

        assertThat(money.getMoney()).isEqualTo(3000);
    }

    @DisplayName("구입한 로또 개수를 알려준다.")
    @Test
    void 구입한_로또를_알려준다() {
        Money money = new Money(3000);

        assertThat(money.getBuyLottoCount()).isEqualTo(3);
    }

}