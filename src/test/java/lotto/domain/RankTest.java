package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RankTest {
    @Test
    @DisplayName("매치 카운트와 보너스 여부에 따라 Rank가 올바르게 반환되는지 확인")
    void matchLottoRank() {
        assertEquals(Rank.SIX, Rank.matchLotto(6, false));
        assertEquals(Rank.FIVE_AND_BONUS, Rank.matchLotto(5, true));
        assertEquals(Rank.FIVE, Rank.matchLotto(5, false));
        assertEquals(Rank.FOUR, Rank.matchLotto(4, false));
        assertEquals(Rank.THREE, Rank.matchLotto(3, false));
        assertEquals(Rank.NONE, Rank.matchLotto(2, false));
    }

    @Test
    @DisplayName("각 Rank의 상금이 정확히 계산되는지 확인")
    void calculateTotalEarnings() {
        assertEquals(2_000_000_000, Rank.SIX.calculateTotalEarnings(1));
        assertEquals(60_000_000, Rank.FIVE_AND_BONUS.calculateTotalEarnings(2));
        assertEquals(3_000_000, Rank.FIVE.calculateTotalEarnings(2));
        assertEquals(150_000, Rank.FOUR.calculateTotalEarnings(3));
        assertEquals(10_000, Rank.THREE.calculateTotalEarnings(2));
        assertEquals(0, Rank.NONE.calculateTotalEarnings(5));
    }

    @Test
    @DisplayName("매치 카운트와 보너스 여부 확인")
    void checkRankProperties() {
        assertEquals(3, Rank.THREE.getMatchCount());
        assertEquals(5_000, Rank.THREE.getPrize());
        assertFalse(Rank.THREE.isMatchBonus());

        assertEquals(5, Rank.FIVE_AND_BONUS.getMatchCount());
        assertEquals(30_000_000, Rank.FIVE_AND_BONUS.getPrize());
        assertTrue(Rank.FIVE_AND_BONUS.isMatchBonus());
    }
}