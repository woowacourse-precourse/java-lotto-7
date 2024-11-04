package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호와_당첨_번호를_비교하여_당첨_내역에_반영한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto.matchNumbers(winningNumber, 7);
        assertThat(Winning.FIRST.getCount()).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호가_5개_매치되고_보너스도_매치() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        lotto.matchNumbers(winningNumber, 6);
        assertThat(Winning.SECOND.getCount()).isEqualTo(1);
    }

    @Test
    void 로또_번호와_당첨_번호가_5개_매치되고_보너스는_매치_안됨() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        lotto.matchNumbers(winningNumber, 8);
        assertThat(Winning.THIRD.getCount()).isEqualTo(1);
    }
}
