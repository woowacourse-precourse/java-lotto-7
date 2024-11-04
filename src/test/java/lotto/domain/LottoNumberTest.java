package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    void 로또_번호가_1_미만이면_예외_발생() {
        assertThatThrownBy(() -> LottoNumber.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_45_초과면_예외_발생() {
        assertThatThrownBy(() -> LottoNumber.valueOf(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 해시_연산_가능() {
        assertThat(LottoNumber.valueOf(42).hashCode()).isEqualTo(LottoNumber.valueOf(42).hashCode());
    }

    @Test
    void 동등성_여부_확인_가능() {
        assertThat(LottoNumber.valueOf(42)).isEqualTo(LottoNumber.valueOf(42));
    }
}