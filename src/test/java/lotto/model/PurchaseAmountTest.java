package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    void should_throwException_When_AmountIsInvalidUnit() {
        // given
        int amount = 100001;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 1,000원 미만이면 예외가 발생한다.")
    void should_throwException_When_AmountBelowMinimum() {
        // given
        int amount = 999;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 100,000원 초과이면 예외가 발생한다.")
    void should_throwException_When_AmountAboveMaximum() {
        // given
        int amount = 100001;

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 99000, 100000})
    @DisplayName("올바른 구입 금액이라면 예외가 발생하지 않는다.")
    void should_createPurchaseAmount_When_ValidValue(int amount) {
        // when & then
        assertDoesNotThrow(() -> new PurchaseAmount(amount));
    }

    @Test
    @DisplayName("구입 금액으로부터 필요한 로또 개수를 반환한다.")
    void should_returnCountOfLottoByAmount() {
        // given
        PurchaseAmount amount = new PurchaseAmount(10000);

        // when
        int countOfLottos = amount.calculateLottoCount();

        // then
        assertEquals(countOfLottos, 10);
    }
}
