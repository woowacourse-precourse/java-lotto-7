package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    void 당첨번호와_중복되면_예외_발생() {
        //given
        Lotto lotto = Lotto.from(Set.of(LottoNumber.valueOf(1), LottoNumber.valueOf(2), LottoNumber.valueOf(3), LottoNumber.valueOf(4), LottoNumber.valueOf(5), LottoNumber.valueOf(6)));

        //then
        assertThatThrownBy(() -> BonusNumber.of(LottoNumber.valueOf(1), lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
