package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseValidatorTest {

    @DisplayName("올바른 금액을 입력하면 해당값을 반환")
    @Test
    void 올바른_금액을_입력하면_해당값을_반환() {
        String validInput = "3000";

        int amount = LottoPurchaseValidator.validateAmount(validInput);

        assertThat(amount).isEqualTo(3000);
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외 발생")
    @Test
    void 숫자가_아닌_값을_입력하면_예외_발생() {
        String nonNumberInput = "abc";

        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(nonNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위의 정수만 입력할 수 있습니다. 혹은 너무 큰 숫자를 입력하셨습니다.");
    }

    @DisplayName("int 범위를 넘어선 숫자를 입력하면 예외 발생")
    @Test
    void 너무_큰_숫자를_입력하면_예외_발생() {
        String tooLargeInput = "1000000000000000";

        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(tooLargeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위의 정수만 입력할 수 있습니다. 혹은 너무 큰 숫자를 입력하셨습니다.");
    }

    @DisplayName("입력값이 0이면 예외 발생")
    @Test
    void 입력값이_0이면_예외_발생() {
        String zeroInput = "0";

        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(zeroInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 0보다 큰 1,000원 단위 정수여야 합니다.");
    }

    @DisplayName("입력값이 음수면 예외 발생")
    @Test
    void 입력값이_음수면_예외_발생() {
        String negativeInput = "-1000";

        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(negativeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 0보다 큰 1,000원 단위 정수여야 합니다.");
    }

    @DisplayName("입력값이 1000 단위가 아닐때 예외 발생")
    @Test
    void 입력값이_천_단위가_아닐때_예외_발생() {
        String nonThousandUnitInput = "1500";

        assertThatThrownBy(() -> LottoPurchaseValidator.validateAmount(nonThousandUnitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
}
