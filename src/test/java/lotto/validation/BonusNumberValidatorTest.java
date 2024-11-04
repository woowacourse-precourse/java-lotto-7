package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void validateNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("숫자가 0으로 시작되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"045", "0", "04"})
    void validateStartWithZero(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("입력된 수가 1~45의 범위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"48", "848"})
    void validateRange(int input) {
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateConvertBonusNumber(input, winningNumber);
        });
    }

    @DisplayName("공백을 포함하여 숫자가 아닌 값을 입력한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"45=", "*", "23 "})
    void validateWithoutNumber(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateBonusNumber(input);
        });
    }

    @DisplayName("당첨 번호와 중복되는 숫자를 입력한 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"4"})
    void validateDuplicateWinningNumber(int input) {
        WinningNumber winningNumber = WinningNumber.from("1,2,3,4,5,6");
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateConvertBonusNumber(input, winningNumber);
        });
    }
}