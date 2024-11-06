package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("각 숫자가 1 ~ 45 가 아닐 시 예외 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void test1(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 숫자는 동일한 객체로 취급한다")
    @Test
    void test2() {
        LottoNumber one = new LottoNumber(1);
        LottoNumber one2 = new LottoNumber(1);
        assertEquals(one,one2);
    }
}
