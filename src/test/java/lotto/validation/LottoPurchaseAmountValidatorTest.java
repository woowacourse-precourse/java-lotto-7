package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountValidatorTest {
    LottoPurchaseAmountValidator validator = new LottoPurchaseAmountValidator();

    @ParameterizedTest
    @ValueSource(strings = {""})
    @DisplayName("입력값이 존재하는지 검증")
    void 입력값이_존재해야_한다(String input) {
        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123a", "abcd", "000c", "123!"})
    @DisplayName("입력값이 숫자인지 검증")
    void 입력값은_숫자여야_한다(String input) {
        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1200", "13001", "0", "34010", "031005"})
    @DisplayName("입력값이 1000 단위인지 검증")
    void 입력값은_1000_단위여야_한다(String input) {
        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
