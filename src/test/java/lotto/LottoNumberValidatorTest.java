package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidatorTest {

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void validatePurchaseAmountWithInvalidAmount() {
        String invalidAmount = "1500";
        assertThatThrownBy(() -> LottoNumberValidator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    void validatePurchaseAmountWithNonNumeric() {
        String invalidAmount = "abc";
        assertThatThrownBy(() -> LottoNumberValidator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호 입력이 올바르면 정상적으로 반환된다.")
    void validateWinningNumbersWithValidInput() {
        String validInput = "1,2,3,4,5,6";
        List<Integer> result = LottoNumberValidator.validateWinningNumbers(validInput);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    void validateWinningNumbersWithInvalidCount() {
        String invalidInput = "1,2,3,4,5";
        assertThatThrownBy(() -> LottoNumberValidator.validateWinningNumbers(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    void validateBonusNumberWithInvalidRange() {
        String invalidInput = "46";
        assertThatThrownBy(() -> LottoNumberValidator.validateBonusNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}