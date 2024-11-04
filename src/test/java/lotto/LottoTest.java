package lotto;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호를_오름차순으로_정렬한다() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        Lotto sortedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(sortedLotto).isEqualTo(lotto);
    }

    @Test
    void 보너스_번호를_포함하면_true를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 6;

        assertThat(lotto.hasBonus(bonusNumber)).isTrue();
    }

    @Test
    void 보너스_번호를_포함하지_않으면_false를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;

        assertThat(lotto.hasBonus(bonusNumber)).isFalse();
    }

    @Test
    void 당첨_번호와_일치하는_개수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winnerNumbers = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        int matchCount = lotto.getMatchCount(winnerNumbers);

        assertThat(matchCount).isEqualTo(3);
    }
}
