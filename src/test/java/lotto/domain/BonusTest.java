package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BonusTest {

    @Test
    void 보너스_번호가_유효한_범위_내에_있으면_객체가_생성된다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus("7", winningLotto);

        // when & then
        assertThat(bonus.containsBonusBall(new Lotto(List.of(7, 8, 9, 10, 11, 12)))).isTrue();
    }

    @Test
    void 보너스_번호가_유효한_범위를_벗어나면_예외가_발생한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> new Bonus("46", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> new Bonus("abc", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호에_포함되면_예외가_발생한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> new Bonus("6", winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}