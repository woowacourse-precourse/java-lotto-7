package lotto.view;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력해 주세요.");
    }

    @DisplayName("유효한 구입 금액을 입력하면 해당 금액을 반환한다.")
    @Test
    void 유효한_구입_금액을_입력하면_해당_금액을_반환한다() {
        int amount = InputValidator.validatePurchaseAmount("3000");
        assertThat(amount).isEqualTo(3000);
    }
}