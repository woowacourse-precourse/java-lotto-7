package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 로또번호는_1미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호는_45초과면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
