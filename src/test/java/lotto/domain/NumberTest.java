package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 주어진_숫자가_1에서_45가_아닐_경우_예외를_던진다(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Number(number);
        });
    }

    @Test
    void 동등성_비교() {
        Number number1 = new Number(1);
        Number number2 = new Number(1);

        assertEquals(number1, number2);
    }
}