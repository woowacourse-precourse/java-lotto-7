package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 보너스_번호_올바르게_생성되어야_한다() {
        //given
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(1));

        //when & then
        assertThat(bonusNumber).isNotNull();
    }

    @Test
    void 보너스_번호는_1_45_사이가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(new LottoNumber(46))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호는_로또에_숫자가_존재하면_True를_반환한다() {
        //given
        Lotto lotto = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)));
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(3));

        //when
        boolean hasBonusNumber = bonusNumber.hasMatchingBonusNumber(lotto);

        //then
        assertThat(hasBonusNumber).isTrue();
    }

    @Test
    void 보너스_번호는_로또에_숫자가_존재하지않으면_False를_반환한다() {
        //given
        Lotto lotto = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6)));
        BonusNumber bonusNumber = new BonusNumber(new LottoNumber(7));

        //when
        boolean hasBonusNumber = bonusNumber.hasMatchingBonusNumber(lotto);

        //then
        assertThat(hasBonusNumber).isFalse();
    }
}
