package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("범위 내 올바르지 않은 금액인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1_000_000, -1000, 0, -9000})
    void throwExceptionIfIsOutOfRangeByTicketPrice(int price) {
        Assertions.assertThatThrownBy(() -> new Money(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("티켓 가격으로 나누어떨어지지 않는 금액인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 2_095, 1_05, 9_500})
    void throwExceptionIfIsNotDivisibleByTicketPrice(int price) {
        Assertions.assertThatThrownBy(() -> new Money(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
