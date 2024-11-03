package lotto.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void 랭크_첫번째_당첨() {
        Rank rank = Rank.getRank(6, false);
        assertEquals(Rank.FIRST, rank);
    }

    @Test
    void 랭크_두번째_당첨_보너스일치() {
        Rank rank = Rank.getRank(5, true);
        assertEquals(Rank.SECOND, rank);
    }

    @Test
    void 랭크_세번째_당첨_보너스불일치() {
        Rank rank = Rank.getRank(5, false);
        assertEquals(Rank.THIRD, rank);
    }

    @Test
    void 랭크_네번째_당첨() {
        Rank rank = Rank.getRank(4, false);
        assertEquals(Rank.FOURTH, rank);
    }

    @Test
    void 랭크_다섯번째_당첨() {
        Rank rank = Rank.getRank(3, false);
        assertEquals(Rank.FIFTH, rank);
    }

    @Test
    void 랭크_당첨없음() {
        Rank rank = Rank.getRank(2, false);
        assertEquals(Rank.NONE, rank);
    }
}
