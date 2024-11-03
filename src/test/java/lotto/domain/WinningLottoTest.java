package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    private final WinningLotto winningLotto;

    public WinningLottoTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningLotto = new WinningLotto(lotto, new BonusNum(7, lotto.getNumbers()));
    }

    @Test
    void 매치되는_개수() {
        assertEquals(winningLotto.countMatches(new Lotto(List.of(1, 2, 3, 4, 5, 6))), 6);
    }

    @Test
    void 주어진로또에_보너스숫자가_포함되어있음() {
        assertTrue(winningLotto.containsBonusNum(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
    }

    @Test
    void 주어진로또에_보너스숫자가_포함X() {
        assertFalse(winningLotto.containsBonusNum(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

}
