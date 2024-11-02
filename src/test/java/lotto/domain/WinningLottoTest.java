package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    public void 모든_로또번호가_일치할_때_일치하는_숫자_개수는_6이다() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        // when
        int matchingCount = winningLotto.countMatchingNumbers(userLotto);

        // then
        assertEquals(6, matchingCount);
    }

    @Test
    public void 일부_로또번호만_일치할_때_일치하는_숫자_개수를_반환한다() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 10);

        // when
        int matchingCount = winningLotto.countMatchingNumbers(userLotto);

        // then
        assertEquals(3, matchingCount);
    }

    @Test
    public void 보너스번호가_일치할_때_true를_반환한다() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto userLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 10);

        // when
        boolean isBonusMatched = winningLotto.isBonusNumberMatched(userLotto);

        // then
        assertTrue(isBonusMatched);
    }

    @Test
    public void 보너스번호가_일치하지_않을_때_false를_반환한다() {
        // given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto userLotto = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 13);

        // when
        boolean isBonusMatched = winningLotto.isBonusNumberMatched(userLotto);

        // then
        assertFalse(isBonusMatched);
    }

    @Test
    public void 당첨번호의_개수가_6개_미만일경우_예외발생() {
        List<Integer> winningNumber = Arrays.asList(19, 11, 2, 4, 6);

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumber, 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    public void 당첨번호가_중복될_경우_예외발생() {
        List<Integer> winningNumber = Arrays.asList(19, 19, 2, 4, 6, 30);

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumber, 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호에 중복된 숫자가 포함될 수 없습니다.");
    }


    @Test
    public void 보너스_번호가_당첨번호와_중복될경우_예외발생() {
        int bonusNumber = 19;
        List<Integer> winningNumber = Arrays.asList(bonusNumber, 11, 2, 3, 4, 6);

        Assertions.assertThatThrownBy(() -> new WinningLotto(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}