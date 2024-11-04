package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    void 구입금액_숫자_유효성_검사() {
        assertThatThrownBy(() -> InputValidator.validatePurchase("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자여야 합니다.");

        assertThatThrownBy(() -> InputValidator.validatePurchase("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");

        assertThatThrownBy(() -> InputValidator.validatePurchase("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @Test
    void 구입금액_정상값_테스트() {
        InputValidator.validatePurchase("1000");
}
