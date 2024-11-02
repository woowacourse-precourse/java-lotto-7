package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {

    @DisplayName("아무 값도 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void validateNull(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumberValidator.validateWinningNumber(input);
        });
    }

}