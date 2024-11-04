package lotto.util;

import lotto.util.validator.WinningNumberValidator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class WinningNumberValidatorTest {

    private final WinningNumberValidator validator = new WinningNumberValidator();

    @Nested
    class 예외가_발생해야하는_경우 {

        @ParameterizedTest
        @ValueSource(strings = {",1,2,3,4,5,6", "1,2,3,4,5,6,"})
        void 쉼표로_시작하거나_끝나는_경우(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,,3,4,5,6", "1,,2,3,4,5,6"})
        void 연속된_쉼표가_포함된_경우(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,a,4,5,6", "1,b,3,4,5,6"})
        void 숫자가_아닌_문자가_포함된_경우(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        void 여섯개의_숫자가_아닌_경우(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_LENGTH.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"46,2,3,4,45,7", "100,101,3,4,5,6","1,2,3,4,5,0"})
        void 일부터_사십오_범위를_넘어가는_경우(String input) {
            assertThatThrownBy(() -> validator.validate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_WINNING_NUMBER_LOTTO_RANGE.getMessage());
        }
    }

    @Nested
    class 예외가_발생하지_않는_경우 {
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6"})
        void 유효한_입력(String input) {
            assertThatCode(() -> validator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}