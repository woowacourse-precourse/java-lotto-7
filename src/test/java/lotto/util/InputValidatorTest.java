package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2200", "999"})
    void validateInvalidPurchaseAmount(String amount) {
        assertThatThrownBy(() -> validator.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("잘못된 형식의 당첨 번호를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2,3,4,5,46", "1,2,3,4,5,0"})
    void validateInvalidWinningNumbers(String numbers) {
        assertThatThrownBy(() -> validator.validateWinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
