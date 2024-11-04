package lotto.presentation;

import java.util.List;
import lotto.global.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("로또 구입 금액을 검증한다.")
    @Nested
    class ValidateMoneyTests {

        @DisplayName("양의 정수가 아닌 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenMoneyIsNotPositiveInteger() {
            assertThatThrownBy(() -> InputValidator.validateMoneyInput("1000j"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        @DisplayName("0을 입력한 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenMoneyIsZero() {
            assertThatThrownBy(() -> InputValidator.validateMoneyInput("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
        }

        @DisplayName("1000으로 나누어 떨어지지 않는 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenMoneyIsNotMultipleOfThousand() {
            assertThatThrownBy(() -> InputValidator.validateMoneyInput("1500"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
        }

        @DisplayName("양의 정수이면서 1000의 배수인 경우 예외를 발생시키지 않는다.")
        @Test
        void shouldNotThrowExceptionWhenMoneyIsValid() {
            InputValidator.validateMoneyInput("3000"); // 예외가 발생하지 않음
        }
    }

    @DisplayName("당첨 번호 입력을 검증한다.")
    @Nested
    class ValidateNumbersTests {

        @DisplayName("쉼표로 구분되지 않은 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenNumbersAreNotCommaSeparated() {
            assertThatThrownBy(() -> InputValidator.validateLottoNumbersInput("1 2 3 4 5 6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBERS.getMessage());
        }

        @DisplayName("숫자가 6개가 아닌 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenNumbersAreNotSix() {
            assertThatThrownBy(() -> InputValidator.validateLottoNumbersInput("1,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_SIZE_OF_NUMBERS.getMessage());
        }

        @DisplayName("1~45 범위를 벗어나는 숫자가 포함된 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenNumberOutOfRange() {
            assertThatThrownBy(() -> InputValidator.validateLottoNumbersInput("1,2,3,4,5,46"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }

        @DisplayName("올바른 형식의 숫자들이 6개인 경우 예외를 발생시키지 않는다.")
        @Test
        void shouldNotThrowExceptionWhenNumbersAreValid() {
            InputValidator.validateLottoNumbersInput("1,2,3,4,5,6"); // 예외가 발생하지 않음
        }
    }

    @DisplayName("보너스번호 포함 입력을 검증한다.")
    @Nested
    class ValidateNumberTests {

        private List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        @DisplayName("양의 정수가 아닌 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenNumberIsNotPositiveInteger() {
            assertThatThrownBy(() -> InputValidator.validateBonusNumberInput("abc", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }

        @DisplayName("숫자가 1 미만인 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenNumberIsLessThanOne() {
            assertThatThrownBy(() -> InputValidator.validateBonusNumberInput("0", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }

        @DisplayName("숫자가 45를 초과하는 경우 예외를 발생시킨다.")
        @Test
        void shouldThrowExceptionWhenNumberIsGreaterThanFortyFive() {
            assertThatThrownBy(() -> InputValidator.validateBonusNumberInput("46", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }

        @DisplayName("보너스 번호가 중복되는 경우 예외가 발생한다.")
        @Test
        void shouldThrowExceptionWhenNumberIsDuplicated() {
            assertThatThrownBy(() -> InputValidator.validateBonusNumberInput("6", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }

        @DisplayName("1 이상 45 이하의 숫자인 경우 예외를 발생시키지 않는다.")
        @Test
        void shouldNotThrowExceptionWhenNumberIsInValidRange() {
            InputValidator.validateBonusNumberInput("23", winningNumbers); // 예외가 발생하지 않음
        }
    }
}
