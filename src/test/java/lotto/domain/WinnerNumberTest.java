package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerNumberTest {
    @Test
    void 당첨번호가_여섯개가_아니라면_예외가_발생한다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,6,7);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(new Lotto(winningLotto), 8);
                })
                .withMessageContaining("6개의 수를 입력하셔야 합니다.");
    }

    @Test
    void 당첨번호가_서로_다른_수가_아니라면_예외가_발생한다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(new Lotto(winningLotto), 8);
                })
                .withMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }

    @Test
    void 보너스번호가_당첨번호에_있는_수라면_예외가_발생한다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new WinningNumber(new Lotto(winningLotto), 6);
                }).withMessageContaining("당첨 번호에 없는 보너스 번호를 입력하셔야 합니다.");
    }

    @Test
    void 로또번호와_당첨번호가_일치하는_개수를_반환한다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(new Lotto(winningLotto), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoRank rank = winningNumber.calculateRank(lotto);

        assertEquals(LottoRank.FIRST_RANK, rank);
    }

    @Test
    void 로또번호와_보너스번호가_일치하다면_TRUE를_반환한다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(new Lotto(winningLotto), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        boolean correct = winningNumber.correctBonus(lotto);

        assertEquals(true, correct);
    }

    @Test
    void 로또번호와_보너스번호가_일치하지않다면_FALSE를_반환한다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(new Lotto(winningLotto), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        boolean correct = winningNumber.correctBonus(lotto);

        assertEquals(false, correct);
    }

    @Test
    void 로또번호_5개와_보너스번호가_일치하다면_SECOND_RANK이다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,8);
        WinningNumber winningNumber = new WinningNumber(new Lotto(winningLotto), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        LottoRank rank = winningNumber.calculateRank(lotto);

        assertEquals(LottoRank.SECOND_RANK, rank);
    }

    @Test
    void 로또번호_5개가_일치하고_보너스번호가_일치하지_않는다면_THIRD_RANK이다() {
        List<Integer> winningLotto = List.of(1,2,3,4,5,8);
        WinningNumber winningNumber = new WinningNumber(new Lotto(winningLotto), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));

        LottoRank rank = winningNumber.calculateRank(lotto);

        assertEquals(LottoRank.THIRD_RANK, rank);
    }
}
