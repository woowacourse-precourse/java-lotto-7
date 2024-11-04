package lotto.domain;

import lotto.global.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void validateMinimumAmount() {
        // given
        long amount = 900;

        // when & then
        assertThatThrownBy(() -> Money.wons(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MINIMUM_PURCHASE_AMOUNT);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void validatePurchaseUnit() {
        // given
        long amount = 1500;

        // when & then
        assertThatThrownBy(() -> Money.wons(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_UNIT);
    }

    @DisplayName("올바른 구입 금액으로 로또 수량을 계산한다.")
    @Test
    void calculateLottoQuantity() {
        // given
        Money money = Money.wons(5000);

        // when
        long quantity = money.getLottoQuantity();

        // then
        assertThat(quantity).isEqualTo(5);
    }
}