package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 보너스_번호를_추첨한다() {
        assertSimpleTest(() -> {
            BonusNumber bonusNumber = new BonusNumber(45);
            assertThat(bonusNumber.getLottoNumber().getNumber()).isEqualTo(45);
        });
    }

    @Test
    void 보너스_번호가_1부터_45사이의_값이_아닌_경우_예외를_발생한다_1() {
        assertThatThrownBy(() -> new BonusNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1부터_45사이의_값이_아닌_경우_예외를_발생한다_2() {
        assertThatThrownBy(() -> new BonusNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
