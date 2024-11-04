package lotto.utils.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @DisplayName("숫자와 쉼표만 입력되었다면, 정상 작동한다.")
    @Test
    void Given_AmountsAreCorrect_When_CheckInput_Then_Success() {

        assertThatCode(() -> WinningNumbersValidator.validateNumbers("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이 입력되었다면, 예외가 발생한다.")
    @EmptySource
    void Given_AmountsAreEmptyString_When_CheckEmptyAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_LOTTO_WINNING_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("연속된 쉼표가 입력되었다면, 예외가 발생한다.")
    @ValueSource(strings = "1,,2,3,4,5,6")
    void Given_NumbersHaveConsecutiveComma_When_CheckUnCorrectForm_Then_Error(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.HAS_CONSECUTIVE_COMMA.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자와 쉼표 이외의 값이 입력되었다면, 예외가 발생한다.")
    @ValueSource(strings = "1,!,3,4,5,6")
    void Given_NumbersHasAnotherForm_When_CheckUnCorrectForm_Then_Error(String input) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_DIGITS_AND_COMMAS_ALLOWED.getMessage());
    }
}