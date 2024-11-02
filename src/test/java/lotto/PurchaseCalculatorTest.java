package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseCalculatorTest {
    public static Calculator calculator;
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
        }, "[ERROR] 구입 금액은 1,000원 이상의 금액이어야 합니다");
    }

    @Test
    void 지불한_금액이_천원단위가_아닐_때_예외_발생(){
        //when&then
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(1500);
        }, "[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 지불한_금액이_정상적으로_입력(){
        //when
        int purchasedCount = calculator.calculate(4000);

        //then
        assertEquals(4, purchasedCount, "[ERROR] 로또 구매 계산이 제대로 이루어지고 있지 않습니다.");
    }
}
