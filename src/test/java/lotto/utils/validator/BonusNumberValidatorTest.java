package lotto.utils.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {


    @DisplayName("1부터 45사이의 숫자가 입력된다면, 정상 작동한다.")
    @Test
    void Given_BonusNumberIsCorrect_When_ValidateNumber_Then_Success() {

        assertThatCode(() -> BonusNumberValidator.validateNumber("1"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("빈 문자열이 입력되었다면, 예외가 발생한다.")
    @EmptySource
    void Given_BonusNumberIsEmptyString_When_CheckEmptyAmounts_Then_Error(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_LOTTO_BONUS_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값(문자)이 입력된다면, 예외가 발생한다.")
    @ValueSource(strings = {"a", "bbb" , "ccc"})
    void Given_BonusNumberIsNotNumberButCharacter_When_CheckNonNumeric_Then_Error(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_DIGITS_ALLOWED_BONUS_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값(기호)이 입력된다면, 예외가 발생한다.")
    @ValueSource(strings = {"-", ".", ","})
    void Given_BonusNumberIsNotNumberButSymbol_When_CheckNonNumeric_Then_Error(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_DIGITS_ALLOWED_BONUS_NUMBER.getMessage());
    }
}