package lotto.validation;

import lotto.exception.PriceToBuyLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceToBuyLottoValidatorTest {

    @DisplayName("가격이 null일 때")
    @Test
    void 로또_가격_null() {
        //given
        Integer price = null;
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLottoValidator.validatePriceToBuyLotto(price);
        });
    }

    @DisplayName("가격이 1000단위가 아닐 때")
    @Test
    void 로또_가격_1000_단위_아님() {
        //given
        Integer price = 2100;
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLottoValidator.validatePriceToBuyLotto(price);
        });
    }

    @DisplayName("가격이 음수일 때")
    @Test
    void 로또_가격_음수() {
        //given
        Integer price = -2000;
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLottoValidator.validatePriceToBuyLotto(price);
        });
    }

    @DisplayName("가격이 2,000,000,000 넘을 때")
    @Test
    void 로또_가격_초과() {
        //given
        Integer price = 2000001000;
        //when
        //then
        assertThrows(PriceToBuyLottoException.class, () -> {
            PriceToBuyLottoValidator.validatePriceToBuyLotto(price);
        });
    }
}
