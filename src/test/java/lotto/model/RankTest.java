package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @Test
    void 일등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.FIRST, Rank.valueOf(lotto, winningLotto));
    }

    @Test
    void 이등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.SECOND, Rank.valueOf(lotto, winningLotto));
    }

    @Test
    void 삼등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.THIRD, Rank.valueOf(lotto, winningLotto));
    }

    @Test
    void 사등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.FOURTH, Rank.valueOf(lotto, winningLotto));
    }

    @Test
    void 오등_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.FIFTH, Rank.valueOf(lotto, winningLotto));
    }

    @Test
    void 낙첨_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertEquals(Rank.NONE, Rank.valueOf(lotto, winningLotto));
    }
}
