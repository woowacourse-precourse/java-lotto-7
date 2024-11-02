package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoConverterTest {

    LottoConverter lottoConverter = new LottoConverter();

    @Test
    @DisplayName("정상적으로 가격이 개수로 변환되는지 테스트")
    public void testConvertPriceToLotto() {
        // given
        int input = 5000;

        // when
        int lottoCount = lottoConverter.convertPriceToLotto(input);

        // then
        assertEquals(5, lottoCount);
    }

    @Test
    @DisplayName("입력된 값이 음수일 때 예외 발생")
    public void testNegativePriceException() {
        // given
        int negativeInput = -5000;

        // when
        IllegalArgumentException negativeException = assertThrows(
                IllegalArgumentException.class,
                () -> lottoConverter.convertPriceToLotto(negativeInput)
        );

        // then
        assertEquals(LottoConverter.UNDER_PRICE_ERROR, negativeException.getMessage());
    }

    @Test
    @DisplayName("입력된 값이 1000원 단위가 아닐 때 예외 발생")
    public void testNonUnitPriceException() {
        // given
        int wrongUnitPrice = 4500;

        // when
        IllegalArgumentException wrongUnitException = assertThrows(
                IllegalArgumentException.class,
                () -> lottoConverter.convertPriceToLotto(wrongUnitPrice)
        );

        // then
        assertEquals(LottoConverter.UNIT_ERROR, wrongUnitException.getMessage());
    }

}