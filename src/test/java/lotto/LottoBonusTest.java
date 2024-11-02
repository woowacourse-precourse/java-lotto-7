package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusTest {

    @DisplayName("보너스_번호가_1_미만이면_예외가_발생한다.")
    @Test
    void 보너스_번호가_1_미만이면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoBonus(0, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스_번호가_45를_초과하면_예외가_발생한다.")
    @Test
    void 보너스_번호가_45를_초과하면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoBonus(46, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스_번호가_당첨번호와_중복되면_예외가_발생한다.")
    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoBonus(1, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

}