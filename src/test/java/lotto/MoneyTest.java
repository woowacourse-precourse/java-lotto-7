package lotto;

import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("올바르지 않은 금액이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {14999, 29999, 10000001, -1, 0, -9000})
    void throwExceptionIfIsNotDivisibleByTicketPrice(int price) {
        Assertions.assertThatThrownBy(() -> new Money(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 티켓 개수를 출력한다.")
    @ParameterizedTest
    @CsvSource({
            "14_000, 14",
            "9_000, 9",
            "77_000, 77"
    })
    void shouldReturnCorrectTicketCount(int price, int count) {
        Assertions.assertThat(new Money(price).getLottoTicketCount())
                .isEqualTo(count);
    }
}
