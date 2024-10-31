package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 자동으로 정렬된다.")
    @Test
    void 로또_번호가_정렬된다() {
        Lotto lotto = new Lotto(List.of(6, 4, 1, 3, 5, 2));
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 반환한다.")
    @Test
    void 당첨_번호와_일치하는_번호의_개수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.matchCount(List.of(1, 2, 3, 7, 8, 9))).isEqualTo(3);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningLotto, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningLotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 등수를 올바르게 반환한다.")
    @Test
    void 당첨_등수를_정확하게_반환한다() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        assertThat(winningLotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoRank.FIRST);
        assertThat(winningLotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(LottoRank.SECOND);
        assertThat(winningLotto.rank(new Lotto(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(LottoRank.THIRD);
        assertThat(winningLotto.rank(new Lotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(LottoRank.FOURTH);
        assertThat(winningLotto.rank(new Lotto(List.of(1, 2, 3, 8, 9, 10)))).isEqualTo(LottoRank.FIFTH);
        assertThat(winningLotto.rank(new Lotto(List.of(1, 2, 8, 9, 10, 11)))).isEqualTo(LottoRank.NONE);
    }
}