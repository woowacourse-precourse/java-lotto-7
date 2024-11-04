package lotto.value;

import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.lottoapp.model.value.LottoNumber;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 로또번호의_범위는_1부터45까지다() {
        assertThatCode(() -> new LottoNumber(1)).doesNotThrowAnyException();
        assertThatCode(() -> new LottoNumber(22)).doesNotThrowAnyException();
        assertThatCode(() -> new LottoNumber(45)).doesNotThrowAnyException();
        assertThatCode(() -> new LottoNumber(0))
                .isInstanceOf(COMMON_EXCEPTION);
        assertThatCode(() -> new LottoNumber(46))
                .isInstanceOf(COMMON_EXCEPTION);
    }

}