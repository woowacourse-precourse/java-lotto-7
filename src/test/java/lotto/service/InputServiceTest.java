package lotto.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    private final InputService inputService = new InputService();

    @Test
    void inputPurchaseAmount_금액이_로또가격으로_나누어떨어지지않을때_예외발생() {
        System.setIn(new java.io.ByteArrayInputStream("1500".getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputService.inputPurchaseAmount(1000);
        });
        assertEquals("[ERROR] 로또 가격 단위는 1000원 입니다", exception.getMessage());
    }

    @Test
    void convertToNumericPurchaseAmount_숫자가_아닐경우_예외발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputService.convertToNumericPurchaseAmount("abc");
        });
        assertEquals("[ERROR] 숫자로 입력해주세요", exception.getMessage());
    }

    @Test
    void convertToNumericPurchaseAmount_정상적인_입력일때_번호_정상반환() {
        int result = inputService.convertToNumericPurchaseAmount("1000");
        assertEquals(1000, result);
    }
}

