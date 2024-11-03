package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LottoValidatorTest {

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
    void 숫자가_아니면_예외를_던진다() {
        // given
        String number = "지종권";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.validNumber(number));
    }
}