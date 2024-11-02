package lotto.exception;

import static org.junit.jupiter.api.Assertions.*;

import lotto.enums.ErrorType;
import org.junit.jupiter.api.Test;

class CheckInputTest {

    @Test
    void 구매금액이_1000원_이하면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkInputMoney(500)
        );
        assertEquals(ErrorType.INVALID_PURCHASE_RANGE.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 구매금액의_단위가_1000원이_아니면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkInputMoney(1234)
        );
        assertEquals(ErrorType.INVALID_PURCHASE_UNIT.getErrorMessage(), exception.getMessage());
    }

    @Test
    void 입력한_구매금액이_정상일때() {
        assertDoesNotThrow(() -> CheckInput.checkInputMoney(3000));
    }


}