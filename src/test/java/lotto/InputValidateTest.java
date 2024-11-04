package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidateTest {

    private final InputValidate validator = new InputValidate();

    @DisplayName("구매 금액이 null일 경우 예외가 발생한다.")
    @Test
    void validatePurchaseAmountNotEmpty_null_throwsException() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 비어 있을 수 없습니다.");
    }

    @DisplayName("구매 금액이 0 이하일 경우 예외가 발생한다.")
    @Test
    void validatePurchaseAmountPositive_nonPositiveAmount_throwsException() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 0보다 큰 양수여야 합니다.");
    }

    @DisplayName("구매 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void validatePurchaseAmountDivisibleByLottoPrice_nonDivisibleAmount_throwsException() {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("당첨 번호가 비어 있을 경우 예외가 발생한다.")
    @Test
    void validateWinningNumbers_emptyList_throwsException() {
        assertThatThrownBy(() -> validator.validateWinningNumbers(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 비어 있을 수 없습니다.");
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void validateNumberRange_outOfRangeNumber_throwsException() {
        assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void validateNoDuplicates_duplicateNumber_throwsException() {
        assertThatThrownBy(() -> validator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에는 중복된 숫자가 없어야 합니다.");
    }

    @DisplayName("보너스 번호가 null일 경우 예외가 발생한다.")
    @Test
    void validateBonusNumberNotEmpty_nullBonusNumber_throwsException() {
        assertThatThrownBy(() -> validator.validateBonusNumber(null, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 비어 있을 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void validateBonusNumberRange_outOfRangeBonusNumber_throwsException() {
        assertThatThrownBy(() -> validator.validateBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void validateBonusNumberDuplication_duplicateWithWinningNumbers_throwsException() {
        assertThatThrownBy(() -> validator.validateBonusNumber(5, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
