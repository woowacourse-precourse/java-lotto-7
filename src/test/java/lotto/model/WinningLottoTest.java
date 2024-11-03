package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private Lotto winningNumbers;
    private Bonus bonus;
    private WinningLotto winningLotto;

    @BeforeEach
    void init() {
        this.winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        this.bonus = new Bonus(winningNumbers.getNumbers(), 7);
        this.winningLotto = new WinningLotto(winningNumbers, bonus);
    }

    @Test
    void 당첨번호와_일치하는_숫자의_개수를_확인한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        assertEquals(3, winningLotto.countMatchingNumbers(lotto));
    }

    @Test
    void 보너스_번호가_일치하면_true를_반환한다() {
        Lotto lottoWithBonus = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertTrue(winningLotto.isBonusMatch(lottoWithBonus));
    }

    @Test
    void 보너스_번호가_일치하지_않으면_false를_반환한다() {
        Lotto lottoWithoutBonus = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        assertFalse(winningLotto.isBonusMatch(lottoWithoutBonus));
    }
}
