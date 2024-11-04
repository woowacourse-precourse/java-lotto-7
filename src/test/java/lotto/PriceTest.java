package lotto;

import static lotto.service.exception.LottoExceptionMessage.PRICE_NOT_POSITIVE_INTEGER;
import static lotto.service.exception.LottoExceptionMessage.PRICE_NOT_THOUSANDS_UNIT;
import static lotto.service.exception.LottoExceptionMessage.PRICE_OVERFLOW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.service.exception.LottoException;
import lotto.view.validation.PriceValidator;
import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    void 가격의_양의_정수가_아니라면_예외발생() {
        String price = "0";
        LottoException e = assertThrows(LottoException.class, () -> {
            PriceValidator.validate(price);
        });
        assertEquals(PRICE_NOT_POSITIVE_INTEGER.message(), e.getMessage());
    }

    @Test
    void 가격의_정수_타입_최대값을_초과할_경우_예외발생() {
        String price = "99999999999999999";
        LottoException e = assertThrows(LottoException.class, () -> {
            PriceValidator.validate(price);
        });
        assertEquals(PRICE_OVERFLOW.message(), e.getMessage());
    }

    @Test
    void 가격이_1000_단위가_아니라면_예외발생() {
        String price = "1001";
        LottoException e = assertThrows(LottoException.class, () -> {
            PriceValidator.validate(price);
        });
        assertEquals(PRICE_NOT_THOUSANDS_UNIT.message(), e.getMessage());
    }
}
