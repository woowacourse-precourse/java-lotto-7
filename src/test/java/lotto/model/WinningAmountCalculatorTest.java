package lotto.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningAmountCalculatorTest {

    WinningAmountCalculator winningAmountCalculator;

    @BeforeEach
    public void setUp() {
        this.winningAmountCalculator = new WinningAmountCalculator
                (new Lotto(List.of(4,45,36,37,19,21)));
    }

    @Test
    @DisplayName("1등 당첨 확인")
    public void 일등_당첨(){
        //given
        Lotto purchasedLotto= new Lotto(List.of(45,4,37,36,19,21));
        //when
        boolean result = winningAmountCalculator.isFirstPrize(purchasedLotto);
        //then
        Assertions.assertTrue(result);
    }
}