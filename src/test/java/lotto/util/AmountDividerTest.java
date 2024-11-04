package lotto.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class AmountDividerTest {

    @Test
    void divide() {
        //given
        int amount = 5000;
        //when
        int result = AmountDivider.divideLottoAmount(amount);
        //then
        assertEquals(5, result);
    }
}