package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountInputValidatorTest {

    @DisplayName("구입 금액이 1,000원 단위가 아닐 경우 맞춤형 예외 메시지 반환")
    @Test
    void 구입금액이_천원단위가_아닐때_맞춤형_예외메시지_반환() {
        String input = "1500";
        String result = InputView.getValidationError(input);
        assertThat(result).isEqualTo(ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_IN_THOUSANDS);
    }

    @DisplayName("구입 금액이 음수일 경우 맞춤형 예외 메시지 반환")
    @Test
    void 구입금액이_음수일_때_맞춤형_예외메시지_반환() {
        String input = "-1000";
        String result = InputView.getValidationError(input);
        assertThat(result).isEqualTo(ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_POSITIVE);
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 맞춤형 예외 메시지 반환")
    @Test
    void 구입금액이_숫자가_아닐_때_맞춤형_예외메시지_반환() {
        String input = "abc";
        String result = InputView.getValidationError(input);
        assertThat(result).isEqualTo(ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_A_NUMBER);
    }

    @DisplayName("구입 금액이 올바른 1,000원 단위일 경우 null 반환")
    @Test
    void 구입금액이_유효할_때_null_반환() {
        String input = "5000";
        String result = InputView.getValidationError(input);
        assertThat(result).isNull();
    }
}
