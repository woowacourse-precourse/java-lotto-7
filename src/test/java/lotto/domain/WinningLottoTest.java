package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    public void 모든_로또번호가_일치할_때_일치하는_숫자_개수는_6이다() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumber, 7);

        // when
        int matchingCount = winningLotto.countMatchingNumbers(winningNumber);

        // then
        assertEquals(6, matchingCount);
    }

    @Test
    public void 일부_로또번호만_일치할_때_일치하는_숫자_개수를_반환한다() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13));
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumber, 7);

        // when
        int matchingCount = winningLotto.countMatchingNumbers(userLotto);

        // then
        assertEquals(3, matchingCount);
    }

    @Test
    public void 보너스번호가_일치할_때_true를_반환한다() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13));
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(winningNumber, 7);

        // when
        boolean isBonusMatched = winningLotto.isBonusNumberMatched(userLotto);

        // then
        assertTrue(isBonusMatched);
    }

    @Test
    public void 보너스번호가_일치하지_않을_때_false를_반환한다() {
        // given
        Lotto winningNumber = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 14));
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumber, 13);

        // when
        boolean isBonusMatched = winningLotto.isBonusNumberMatched(userLotto);

        // then
        assertFalse(isBonusMatched);
    }

    @Test
    public void 당첨번호의_개수가_6개_미만일경우_예외발생() {
        Assertions.assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 11, 12)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @Test
    public void 당첨번호가_중복될_경우_예외발생() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 11, 20, 20)), 23))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호에 중복된 숫자가 포함될 수 없습니다.");
    }


    @Test
    public void 보너스_번호가_당첨번호와_중복될경우_예외발생() {
        int bonusNumber = 19;

        Assertions.assertThatThrownBy(
                        () -> new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 11, 19, 20)), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}