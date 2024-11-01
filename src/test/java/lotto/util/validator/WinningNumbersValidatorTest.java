package lotto.util.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersValidatorTest {

    @Test
    void 당첨번호가_음수나_0일_경우_예외발생() {
        String invalidWinningNumbers = "-1";

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_양의정수일_경우_정상적으로_통과() {
        String validWinningNumbers = "1,2,3,4,5,6";
        WinningNumbersValidator.validateWinningNumbers(validWinningNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2","33,22"})
    void 당첨번호가_6자리가_아닐_경우_예외발생(String invalidWinningNumbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_중복될_경우_예외발생() {
        String invalidWinningNumbers = "1,2,3,5,5,5";
        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_범위를_벗어날때_예외발생() {
        String outOfRangeWinningNumber = "1,2,3,4,5,100"; // 범위를 벗어난 보너스 번호

        assertThatThrownBy(() -> WinningNumbersValidator.validateWinningNumbers(outOfRangeWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
