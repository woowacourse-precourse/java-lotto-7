package lotto.utils.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class AmountsValidatorTest {

    @DisplayName("1000이상 100000이하의 금액이 입력되었을 때, 정상작동한다.")
    @Test
    void Given_AmountsAreCorrect_When_CheckInput_Then_Success() {

        assertThatCode(() -> AmountsValidator.validateLottoAmount("1000"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이 입력되었다면, 예외 처리된다.")
    @EmptySource
    void Given_AmountsAreEmptyString_When_CheckEmptyAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값이 입력되었다면, 예외 처리된다.")
    @ValueSource(strings = {"asd", "-", ",", "b", "한글"})
    void Given_AmountsAreNonNumeric_When_CheckNonNumeric_Then_Error(String input) {
        assertThatThrownBy(() -> AmountsValidator.validateLottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_DIGITS_ALLOWED_AMOUNTS.getMessage());
    }
}