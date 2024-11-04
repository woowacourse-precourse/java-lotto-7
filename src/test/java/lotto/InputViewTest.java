package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class InputViewTest {

    @Test
    @DisplayName("정상적인 금액 입력 테스트")
    void testValidPurchaseAmount() {
        int amount = InputView.parseAndValidateAmount("5000");
        Assertions.assertEquals(5000, amount, "입력한 구입 금액이 일치해야 합니다.");
    }

    @Test
    @DisplayName("비정상적인 금액 입력 테스트 - 숫자가 아닌 값")
    void testInvalidAmountNonNumeric() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> InputView.parseAndValidateAmount("abc")
        );
        Assertions.assertEquals("[ERROR] 구입 금액은 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("비정상적인 금액 입력 테스트 - 1,000원 단위가 아닌 경우")
    void testInvalidAmountNotMultipleOfThousand() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> InputView.parseAndValidateAmount("1500")
        );
        Assertions.assertEquals("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("비정상적인 금액 입력 테스트 - 1,000원 미만")
    void testInvalidAmountBelowMinimum() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> InputView.parseAndValidateAmount("500")
        );
        Assertions.assertEquals("[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("비정상적인 금액 입력 테스트 - 너무 큰 금액")
    void testInvalidAmountAboveMaximum() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> InputView.parseAndValidateAmount("2000000")
        );
        Assertions.assertEquals("[ERROR] 구입 금액이 너무 큽니다. 최대 1,000,000원까지 가능합니다.", exception.getMessage());
    }
}
