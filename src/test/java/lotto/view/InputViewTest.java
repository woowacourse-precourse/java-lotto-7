package lotto.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void 구매_금액이_null일_때_예외(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateAmountInput(null);
        }, "[ERROR] 구입 금액을 입력해 주세요.");
    }

    @Test
    void 구매_금액이_빈_문자열일_떄_예외_발생(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateAmountInput("");
        }, "[ERROR] 구입 금액을 입력해 주세요.");
    }

    @Test
    void 구매_금액이_숫자가_아닐_때_예와_발생(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateAmountInput("invalid123");
        }, "[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @Test
    void 구매_금액이_올바른_입력일_때(){
        assertDoesNotThrow(() -> InputView.validateAmountInput("1000"));
    }

    @Test
    void 구매_금액이_1000원_단위가_아닐떄(){
        assertEquals(InputView.isModZero(1123), false);
    }

    @Test
    void 구매_금액이_1000원_단위일_때(){
        assertEquals(InputView.isModZero(100000), true);
    }

}
