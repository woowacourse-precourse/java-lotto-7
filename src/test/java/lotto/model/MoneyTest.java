package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1500, 2200, -1000, 0, 1111})
    void validateInvalidPurchasingAmount(int amount) {
        assertThatThrownBy(() -> new Money(amount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액은 1,000원 단위로 입력해주세요.");
    }

    @DisplayName("올바른 구입 금액으로 로또 수량을 계산한다")
    @Test
    void calculateLottoCount() {
        Money money = new Money(5000);
        assertThat(money.getLottoCount()).isEqualTo(5);
    }

    @DisplayName("구입 금액이 Integer.MAX_VALUE보다 큰 경우 예외가 발생한다")
    @Test
    void validateExceedAmount() {
        assertThatThrownBy(() -> new Money(Integer.MAX_VALUE + 1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("구입 금액이 너무 큽니다.");
    }

    @DisplayName("정상적인 구입 금액을 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    void createValidMoney(int amount) {
        Money money = new Money(amount);
        assertThat(money.getPurchasingMoney()).isEqualTo(amount);
    }
}