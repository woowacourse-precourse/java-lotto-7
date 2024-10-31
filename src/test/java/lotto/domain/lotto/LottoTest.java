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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("주어진 당첨 번호에 대해 올바른 순위를 반환할 수 있다.")
    void 당첨_번호로_올바른_순위를_반환할_수_있다() {
        // given
        Lotto lotto = new Lotto(winningLotto.basicNumbers());

        // when
        Rank rank = lotto.getRank(winningLotto);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }
}
