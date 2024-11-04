package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("구매한 로또의 총 수익률을 구한다")
    void 구매한_로또의_총_수익률을_구한다() {
        //given
        Long totalPrizeAmount = 5_000L;
        Money money = new Money(8000);

        //when
        double yield = Calculator.calculateYield(totalPrizeAmount, money);

        //then
        assertThat(yield).isEqualTo(62.5);
    }
}