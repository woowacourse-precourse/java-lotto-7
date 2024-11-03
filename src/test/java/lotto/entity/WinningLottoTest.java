package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 사용자가_6개_일치하여_1등() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.getRank(Set.of(1, 2, 3, 4, 5, 6));
        assertEquals(Rank.FIRST, rank);
    }

    @Test
    void 사용자가_5개_일치하고_보너스일치하여_2등() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.getRank(Set.of(1, 2, 3, 4, 5, 7));
        assertEquals(Rank.SECOND, rank);
    }

    @Test
    void 사용자가_5개_일치하여_3등() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.getRank(Set.of(1, 2, 3, 4, 5));
        assertEquals(Rank.THIRD, rank);
    }

    @Test
    void 사용자가_4개_일치하여_4등() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.getRank(Set.of(1, 2, 3, 4));
        assertEquals(Rank.FOURTH, rank);
    }

    @Test
    void 사용자가_3개_일치하여_5등() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.getRank(Set.of(1, 2, 3));
        assertEquals(Rank.FIFTH, rank);
    }

    @Test
    void 사용자가_2개_일치하여_당첨없음() {
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        Rank rank = winningLotto.getRank(Set.of(1, 2));
        assertEquals(Rank.NONE, rank);
    }
}
