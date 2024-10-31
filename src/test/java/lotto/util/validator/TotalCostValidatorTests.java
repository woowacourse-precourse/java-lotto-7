package lotto.util.validator;

import static lotto.util.message.OutputMessage.ERROR_MESSAGE;
import static lotto.util.validator.TotalCostValidator.validateDividedByLottoPrice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TotalCostValidatorTests {

    @ParameterizedTest
    @DisplayName("입력한 로또 구입 금액이 로또 1장의 가격으로 나누어 떨어지지 않으면 예외 발생")
    @ValueSource(strings = {"1", "999", "1001"})
    void validateDividedByLottoPriceExceptionTest(String input) {
        assertThatThrownBy(() -> validateDividedByLottoPrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("입력한 로또 구입 금액이 로또 1장 가격으로 나누어 떨어지면 구입 금액을 정수형으로 반환")
    void validateDividedByLottoPriceTest() {
        String input = "1000";
        int expected = 1000;

        assertThat(validateDividedByLottoPrice(input)).isEqualTo(expected);
    }
}