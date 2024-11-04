package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoSimulatorValidationTest {
    @Test
    @DisplayName("로또 구입 금액이 1,000원 단위로 나누어 떨어지지 않는 경우 예외발생")
    void validateLottoCost_InvalidCost_ExceptionThrown() {
        assertThatThrownBy(() -> LottoSimulatorValidation.validateLottoCost("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 숫자가 아닌 경우 예외발생")
    void validateCostFormat_InvalidNumberFormat_ExceptionThrown() {
        assertThatThrownBy(() -> LottoSimulatorValidation.validateCostFormat("1500j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
