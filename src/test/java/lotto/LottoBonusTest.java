package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusTest {

    @DisplayName("보너스_번호가_1_미만이면_예외가_발생한다.")
    @Test
    void 보너스_번호가_1_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonus(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스_번호가_45를_초과하면_예외가_발생한다.")
    @Test
    void 보너스_번호가_45를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}