package lotto.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    // SUCCESS
    @Test
    void 숫자인지_확인하다() {
        // given
        String number = "1000";

        // when
        int price = LottoValidator.validNumber(number);

        // then
        assertEquals(1000, price);
    }

    @Test
    public void 천원_단위인지_확인하다() {
        // given
        int price = 1000;

        // when

        // then
        assertDoesNotThrow(() -> LottoValidator.validatePriceUnit(price));
    }

    // EXCEPTION
    @Test
    void 숫자가_아니면_예외를_던진다() {
        // given
        String number = "지종권";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validNumber(number));
    }

    @Test
    void 천원단위가_아니면_예외를_던진다() {
        // given
        int price = 0;

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validatePriceUnit(price));
    }
}