package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 주어진_숫자가_1에서_45가_아닐_경우_예외를_던진다(int number) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(number);
        });
    }

    @Test
    void 동등성_비교() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);

        assertEquals(lottoNumber1, lottoNumber2);
    }
}