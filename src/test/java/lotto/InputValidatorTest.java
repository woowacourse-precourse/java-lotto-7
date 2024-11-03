package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"999", "1001", "101000"})
    void purchaseAmountValidator_예외_테스트(String purchaseAmountStr) {
        assertThat(InputValidator.purchaseAmountValidator(purchaseAmountStr))
                .isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5",
            "1,2,3,4,5,6,7",
            "1,2,3,4,5,a",
            "-1,2,3,4,5,6",
            "1,2,3,4,5,46",
            "1,1,2,3,4,5"})
    void winningNumberValidator_예외_테스트(String winningNumberStr) {
        assertThat(InputValidator.winningNumberValidator(winningNumberStr))
                .isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "46", "1"})
    void bonusNumberValidator_예외_테스트(String bonusNumberStr) {
        InputValidator.winningNumberValidator("1,2,3,4,5,6");
        assertThat(InputValidator.bonusNumberValidator(bonusNumberStr))
                .isEqualTo(false);
    }
}