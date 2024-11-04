package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("로또 구매금액이 빈 값일 시 예외가 발생한다.")
    @Test
    void 구입금액이_빈_값일_시_예외처리() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedPurchaseAmount(input));
        assertEquals("[ERROR]구입금액이 입력되지 않았습니다.", exception.getMessage());
    }

    @DisplayName("로또 구매금액이 음수일 시 예외가 발생한다.")
    @Test
    void 구입금액이_음수일_시_예외처리() {
        String input = "-8000";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedThousandUnitAmount(input));
        assertEquals("[ERROR]구입 금액은 양수여야 합니다.", exception.getMessage());
    }

    @DisplayName("로또 구매금액에 문자열이 포함될 시 예외가 발생한다.")
    @Test
    void 구입금액에_문자열이_포함될_시_예외처리() {
        String input = "6000a";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedThousandUnitAmount(input));
        assertEquals("[ERROR]구입 금액은 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("로또 구매금액이 1,000원 단위로 나눠지지 않을 시 예외가 발생한다.")
    @Test
    void 구입금액이_1000원_단위가_아닐_시_예외처리() {
        String input = "6100";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedThousandUnitAmount(input));
        assertEquals("[ERROR]구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

}