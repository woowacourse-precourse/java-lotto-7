package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("입력된 금액을 정확히 저장")
    void saveExactlyMoney() {
        String input = "5000";

        Money money = new Money(input);

        assertThat(money.getValue()).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("입력 금액이 숫자가 아닐 시 예외 발생")
    void invalidMoneyInputException() {
        String input = "1000a";

        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("입력 금액이 1000으로 나누어 떨어지지 않을 시 예외 발생")
    void notDivisibleByThousandException() {
        String input = "1500";

        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}