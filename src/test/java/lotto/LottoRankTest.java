package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {

    @Test
    @DisplayName("1등 당첨 기준 및 상금 확인")
    void testFirstRank() {
        assertEquals(6, LottoRank.FIRST.getMatchCount());
        assertEquals(false, LottoRank.FIRST.isMatchBonus());
        assertEquals(2_000_000_000, LottoRank.FIRST.getPrize());
    }

    @Test
    @DisplayName("2등 당첨 기준 및 상금 확인")
    void testSecondRank() {
        assertEquals(5, LottoRank.SECOND.getMatchCount());
        assertEquals(true, LottoRank.SECOND.isMatchBonus());
        assertEquals(30_000_000, LottoRank.SECOND.getPrize());
    }

    @Test
    @DisplayName("3등 당첨 기준 및 상금 확인")
    void testThirdRank() {
        assertEquals(5, LottoRank.THIRD.getMatchCount());
        assertEquals(false, LottoRank.THIRD.isMatchBonus());
        assertEquals(1_500_000, LottoRank.THIRD.getPrize());
    }

    @Test
    @DisplayName("4등 당첨 기준 및 상금 확인")
    void testFourthRank() {
        assertEquals(4, LottoRank.FOURTH.getMatchCount());
        assertEquals(false, LottoRank.FOURTH.isMatchBonus());
        assertEquals(50_000, LottoRank.FOURTH.getPrize());
    }

    @Test
    @DisplayName("5등 당첨 기준 및 상금 확인")
    void testFifthRank() {
        assertEquals(3, LottoRank.FIFTH.getMatchCount());
        assertEquals(false, LottoRank.FIFTH.isMatchBonus());
        assertEquals(5_000, LottoRank.FIFTH.getPrize());
    }
}
