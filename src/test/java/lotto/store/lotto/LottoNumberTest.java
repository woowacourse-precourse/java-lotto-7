package lotto.store.lotto;

import lotto.store.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("로또 번호 1~45 범위를 벗어나면 예외가 발생한다")
    @Test
    void test1() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(100));
    }

    @DisplayName("번호가 같은 로또 번호는 동등하게 취급한다.")
    @Test
    void test2() {
        assertEquals(new LottoNumber(1), new LottoNumber(1));
        assertNotEquals(new LottoNumber(1), new LottoNumber(2));
    }

}