package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void 로또_번호가_정상적으로_생성된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsOnly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호에_음수가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_오름차순으로_정렬된다() {
        Lotto lotto = new Lotto(List.of(6, 3, 1, 5, 2, 4));
        assertThat(lotto.getSortedAscendingNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 로또_번호에_특정_번호가_포함되어_있는지_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.hasNumber(3)).isTrue();
        assertThat(lotto.hasNumber(7)).isFalse();
    }

    @Test
    void 로또_번호와_당첨_번호의_일치_개수_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        assertThat(lotto.matchCount(winningLotto)).isEqualTo(4);
    }
}
