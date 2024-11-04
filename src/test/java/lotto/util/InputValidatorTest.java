package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("구입 금액이 1,000원 단위인 경우 정상 처리")
    void validatePurchaseAmountValid() {
        InputValidator.validatePurchaseAmount("10000");
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외 발생")
    void validatePurchaseAmountInvalidUnit() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("14500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입은 1,000원 단위만 가능합니다.");
    }

    @Test
    @DisplayName("구입 금액이 음수일 경우 예외 발생")
    void validatePurchaseAmountNegative() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양수를 입력해주세요.");
    }

    @Test
    @DisplayName("구입 금액에 숫자가 아닌 문자가 포함된 경우 예외 발생")
    void validatePurchaseAmountNonNumeric() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력하여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개의 숫자로 구성된 경우 정상 처리")
    void validateWinningNumbersValid() {
        List<Integer> result = InputValidator.validateWinningNumbers("1,2,3,4,5,6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호에 쉼표로 구분되지 않은 경우 예외 발생")
    void validateWinningNumbersInvalidSeparator() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1.2'3,4'5;6;7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }


    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 문자가 포함된 경우 예외 발생")
    void validateBonusNumberNonNumeric() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다. 다시 입력해주세요.");
    }
}