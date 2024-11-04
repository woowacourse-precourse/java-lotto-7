package lotto.view;

import static lotto.MessageContainer.ERROR_MESSAGE;
import static lotto.MessageContainer.NEITHER_DIGIT_NOR_DELIMITER_ERROR;
import static lotto.MessageContainer.NON_DIGIT_ERROR;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("문자열에 숫자가 아닌 문자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "+2", "3,4,5", "3000j", "", " ", "1000원", "만원"})
    void throwIllegalArgumentExceptionIfNonDigitCharIsIn(String input) {
        assertThatThrownBy(() -> new InputValidator().validateDigitOnly(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE)
                .hasMessage(NON_DIGIT_ERROR);
    }

    @DisplayName("문자열이 숫자로만 구성되어 있으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234567890", "0", "1", "8000", "1999999999"})
    void doesNotThrowAnyExceptionWithDigitOnly(String input) {
        assertThatCode(() -> new InputValidator().validateDigitOnly(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("문자열에 숫자와 구분자가 아닌 문자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "+2", "3.4.5", "", " ", "일,이,삼", "four,five,six"})
    void throwIllegalArgumentExceptionIfNonDigitNonDelimiterCharIsIn(String input) {
        assertThatThrownBy(() -> new InputValidator().validateDigitAndDelimiterOnly(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE)
                .hasMessage(NEITHER_DIGIT_NOR_DELIMITER_ERROR);
    }

    @DisplayName("문자열이 숫자와 구분자로만 구성되어 있으면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "0", ",", "7,8,", ",9,10"})
    void doesNotThrowAnyExceptionWithDigitAndDelimiterOnly(String input) {
        assertThatCode(() -> new InputValidator().validateDigitAndDelimiterOnly(input))
                .doesNotThrowAnyException();
    }
}