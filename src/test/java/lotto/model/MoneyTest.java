package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("금액 입력 예외 테스트")
    @NullAndEmptySource
    @ValueSource(strings = {"0", "500", "1500"})
    void invalidMoney(final String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 금액 입력 테스트")
    void validMoney() {
        Money money = new Money("2000");

        assertNotNull(money);
    }

    @Test
    @DisplayName("구입한 로또 개수 계산 테스트")
    void calculateLottoCount() {
        Money money = new Money("2000");

        int expectedLottoCount = 2;

        assertThat(money.calculateLottoCount()).isEqualTo(expectedLottoCount);
    }
}
