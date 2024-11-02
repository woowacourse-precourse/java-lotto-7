package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void FIRST_로또를_비교한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.FIRST, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    public void SECOND_로또를_비교한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        int bonusNumber = 6;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.SECOND, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    public void THIRD_로또를_비교한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.THIRD, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    public void FORTH_로또를_비교한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.FORTH, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    public void FIFTH_로또를_비교한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.FIFTH, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    public void NOTHING_로또를_비교한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        int bonusNumber = 7;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.NOTHING, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }

    @Test
    public void NOTHING_로또를_비교한다2() {
        Lotto winningLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        int bonusNumber = 1;

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(Result.NOTHING, lotto.compareWithWinningLotto(winningLotto, bonusNumber));
    }
}
