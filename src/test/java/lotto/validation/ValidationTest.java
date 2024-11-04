package lotto.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void 구입금액이_빈_값일_시_예외처리() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedPurchaseAmount(input));
        assertEquals("[ERROR]구입금액이 입력되지 않았습니다.", exception.getMessage());
    }

}