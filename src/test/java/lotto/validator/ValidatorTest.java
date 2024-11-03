package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
    @ParameterizedTest
    @DisplayName("구입 금액이 양의 정수 형태이며, 1000원 단위가 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "-1", "0.1", "1100", "2147484000"})
    void throwExceptionIfMoneyInputIsNeitherPositiveIntegerNorDivisibleByThousand(String moneyInput) {
        assertThatThrownBy(() -> Validator.validateMoneyInput(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 양의 정수 형태가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "-1,1,2,3,4,5", "0.1,4,6,1"})
    void throwExceptionIfWinningLottoNumbersInputIsNotPositiveInteger(String numbersInput) {
        assertThatThrownBy(() -> Validator.validateNumbersInput(numbersInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
