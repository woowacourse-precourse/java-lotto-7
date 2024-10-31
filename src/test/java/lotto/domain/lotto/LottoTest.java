package lotto.domain.lotto;

import lotto.domain.rank.vo.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final WinningLotto winningLotto = new FixedWinningLotto();

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
    @DisplayName("주어진 당첨 번호에 대해 1위를 반환할 수 있다.")
    void 당첨_번호로_1위를_반환할_수_있다() {
        // given
        Lotto lotto = new Lotto(winningLotto.basicNumbers());

        // when
        Rank rank = lotto.getRank(winningLotto);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }

    @Test
    @DisplayName("주어진 당첨 번호에 대해 2위를 반환할 수 있다.")
    void 당첨_번호로_2위를_반환할_수_있다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = lotto.getRank(winningLotto);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }

    @Test
    @DisplayName("주어진 당첨 번호에 대해 3위를 반환할 수 있다.")
    void 당첨_번호로_3위를_반환할_수_있다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 8);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = lotto.getRank(winningLotto);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.THIRD);
    }

    @Test
    @DisplayName("주어진 당첨 번호에 대해 4위를 반환할 수 있다.")
    void 당첨_번호로_4위를_반환할_수_있다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 8, 9);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = lotto.getRank(winningLotto);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("주어진 당첨 번호에 대해 5위를 반환할 수 있다.")
    void 당첨_번호로_5위를_반환할_수_있다() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 8, 9, 10);
        Lotto lotto = new Lotto(numbers);

        // when
        Rank rank = lotto.getRank(winningLotto);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIFTH);
    }
}
