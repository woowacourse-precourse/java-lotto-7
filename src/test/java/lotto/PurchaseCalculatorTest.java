package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.domain.calculator.Calculator;
import lotto.domain.calculator.PurchaseCalculator;
import lotto.utils.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseCalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void beforeEach() {
        //given
        calculator = new PurchaseCalculator();
    }

    @Test
    void 로또금액보다_작은_값이_입력되었을_때_예외_발생(){
        //when&then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(500);
        }, ErrorMessages.ERROR_MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 지불한_금액이_천원단위가_아닐_때_예외_발생(){
        //when&then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(1500);
        }, ErrorMessages.ERROR_INVALID_AMOUNT_UNIT.getMessage());
    }

    @Test
    void 지불한_금액이_정상적으로_입력(){
        //when
        int purchasedCount = calculator.calculate(4000);

        //then
        assertEquals(4, purchasedCount, ErrorMessages.ERROR_INCORRECT_LOTTO_PURCHASE_CALCULATION.getMessage());
    }
}
