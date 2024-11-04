package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validatePurchaseAmount("abc"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        // given & when
        assertThatThrownBy(() -> Validator.validatePurchaseAmount("1500"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("구입 금액이 올바르면 예외가 발생하지 않는다.")
    @Test
    void 구입_금액이_올바르면_예외가_발생하지_않는다() {
        Validator.validatePurchaseAmount("2000");
    }
}
