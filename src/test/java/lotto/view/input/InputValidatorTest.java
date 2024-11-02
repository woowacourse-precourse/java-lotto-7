package lotto.view.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 구매_금액_검증_성공() {
        //given
        Integer amount = 10000;

        //then
        assertDoesNotThrow(() -> validator.validateAmount(amount));
    }

    @Test
    void 구매_금액_단위_검증_실패() {
        //given
        Integer amount = 10090;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateAmount(amount));
    }

    @Test
    void 최대_구매_금액_검증_실패() {
        //given
        Integer amount = 100010;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateAmount(amount));
    }

    @Test
    void 최소_구매_금액_검증_실패() {
        //given
        Integer amount = 100;

        //then
        assertThrows(IllegalArgumentException.class, () -> validator.validateAmount(amount));
    }


}