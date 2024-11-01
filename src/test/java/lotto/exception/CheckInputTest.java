package lotto.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckInputTest {

    @Test
    void 구매금액이_1000원_이하면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkInputMoney(500)
        );
        assertEquals("[ERROR] 구입금액은 1000원 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    void 구매금액의_단위가_1000원이_아니면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> CheckInput.checkInputMoney(1234)
        );
        assertEquals("[ERROR] 구입금액은 1000원단위어야 합니다.", exception.getMessage());
    }

    @Test
    void 입력한_구매금액이_정상일때() {
        assertDoesNotThrow(() -> CheckInput.checkInputMoney(3000));
    }


}