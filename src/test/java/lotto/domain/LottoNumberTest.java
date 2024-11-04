package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    @DisplayName("범위를 벗어난 로또 번호가 예외를 발생시키는지 테스트")
    void 범위_벗어난_로또_번호_예외() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(LottoException.class);

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(LottoException.class);
    }

}