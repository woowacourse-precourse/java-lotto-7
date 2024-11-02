package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, Integer.MAX_VALUE})
    public void whenMoreThan45_thenThrowException(int num) {
        //when & then
        assertThatThrownBy(() -> LottoNumber.valueOf(num))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    public void whenLessThan1_thenThrowException(int num) {
        //when & then
        assertThatThrownBy(() -> LottoNumber.valueOf(num))
            .isInstanceOf(IllegalArgumentException.class);
    }
}