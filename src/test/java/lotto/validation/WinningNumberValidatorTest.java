package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberValidatorTest {

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }

    @DisplayName("구분자가 쉼표(,)가 아니면 예외가 발생한다.")
    @Test
    void validateNotComma() {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber("1 2 3 4 5 7");
        });
    }

    @DisplayName("쉼표(,)가 2개 이상 연속적으로 입력되면 예외가 발생한다.")
    @Test
    void validateSeparatorContinue() {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber("1,2,3,4,5,,,7");
        });
    }

    @DisplayName("쉼표(,) 사이에 공백이 있을 경우 연속적으로 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3, ,5,,,7", "1,2,3,   ,5,,,7"})
    void validateNoEmptyBetweenCommas(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }

    @DisplayName("6개의 숫자를 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validateNotSixNumbers(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }

    @DisplayName("숫자가 0으로 시작되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,03,4,5,7", "1,2,0,4,5,6", "1,2,044,4,5,6"})
    void validateStartWithZero(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }

    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,3,7", "11,2,0,4,5,11"})
    void validateNumberDuplicate(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }

    @DisplayName("입력된 수가 1~45의 범위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,3,71", "11,2,24,4,5,111"})
    void validateRange(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }

    @DisplayName("쉼표와 숫자 이외의 문자가 입력된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3a,4,5,6", "1, 2, 3, 4, 5, 6"})
    void validateOnlyNumbersAndCommas(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumberValidator.validateWinningNumber(input);
        });
    }
}