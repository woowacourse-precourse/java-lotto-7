package lotto.application.validation;

import lotto.util.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountValidatorTest {
    private final AmountValidator amountValidator = new AmountValidator();

    @Test
    @DisplayName("올바른 구입 금액 입력 시 검증 테스트")
    void validateValidAmount() {
        String input = "5000";
        int result = amountValidator.validate(input);
        assertEquals(5000, result, "유효한 금액 입력에 대한 검증 결과가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000 단위가 아닐 때 예외 처리 테스트")
    void validateInvalidAmountUnit() {
        String input = "1500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> amountValidator.validate(input));
        assertEquals(ErrorMessages.INVALID_AMOUNT_UNIT.getMessage(), exception.getMessage(), "올바르지 않은 금액 단위 입력 시의 예외 메시지가 예상과 다릅니다.");
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아닐 때 예외 처리 테스트")
    void validateInvalidAmountFormat() {
        String input = "abcd";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> amountValidator.validate(input));
        assertEquals(ErrorMessages.INVALID_AMOUNT_FORMAT.getMessage(), exception.getMessage(), "잘못된 형식의 입력에 대한 예외 메시지가 예상과 다릅니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000 미만일 때 예외 처리 테스트")
    void validateAmountBelowMinimum() {
        String input = "500";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> amountValidator.validate(input));
        assertEquals(ErrorMessages.INVALID_AMOUNT_UNIT.getMessage(), exception.getMessage(), "1000 미만의 금액 입력에 대한 예외 메시지가 예상과 다릅니다.");
    }
}