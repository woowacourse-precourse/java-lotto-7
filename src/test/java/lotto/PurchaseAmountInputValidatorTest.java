package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountInputValidatorTest {

    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 구입금액이_천원단위가_아닐때_예외가_발생한다() {
        String input = "1500";
        boolean result = InputView.isValidPurchaseAmount(input);
        assertThat(result).isFalse();
    }

    @DisplayName("구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void 구입금액이_음수일_때_예외가_발생한다() {
        String input = "-1000";
        boolean result = InputView.isValidPurchaseAmount(input);
        assertThat(result).isFalse();
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 구입금액이_숫자가_아닐_때_예외가_발생한다() {
        String input = "abc";
        boolean result = InputView.isValidPurchaseAmount(input);
        assertThat(result).isFalse();
    }

    @DisplayName("구입 금액이 올바른 1,000원 단위일 경우 정상적으로 처리된다.")
    @Test
    void 구입금액이_유효할_때_정상처리() {
        String input = "5000";
        boolean result = InputView.isValidPurchaseAmount(input);
        assertThat(result).isTrue();
    }
}