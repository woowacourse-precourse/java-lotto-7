package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Winning;
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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 미당첨_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(5, 6, 7, 8, 9, 10);
        int bonus = 4;

        // when
        Winning winning = lotto.checkWinnings(winningNumbers, bonus);

        //then
        assertThat(winning).isEqualTo(Winning.FAIL);
    }

    @Test
    void 당첨_개수_6개_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        // when
        Winning winning = lotto.checkWinnings(winningNumbers, bonus);

        //then
        assertThat(winning).isEqualTo(Winning.SIX);
    }

    @Test
    void 보너스_포함_당첨_테스트() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int bonus = 6;

        // when
        Winning winning = lotto.checkWinnings(winningNumbers, bonus);

        //then
        assertThat(winning).isEqualTo(Winning.FIVE_BONUS);
    }
}
