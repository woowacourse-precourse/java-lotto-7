package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {

    @Test
    @DisplayName("1등 당첨 기준 및 상금 확인")
    void 일등_당첨_기준은_숫자가_6개_일치하고_상금이_2000000000이다() {
        assertEquals(6, LottoRank.FIRST.getMatchCount());
        assertEquals(false, LottoRank.FIRST.isMatchBonus());
        assertEquals(2_000_000_000, LottoRank.FIRST.getPrize());
    }

    @Test
    @DisplayName("2등 당첨 기준 및 상금 확인")
    void 이등_당첨_기준은_숫자가_5개_일치하고_보너스_번호_일치하며_상금이_30000000이다() {
        assertEquals(5, LottoRank.SECOND.getMatchCount());
        assertEquals(true, LottoRank.SECOND.isMatchBonus());
        assertEquals(30_000_000, LottoRank.SECOND.getPrize());
    }

    @Test
    @DisplayName("3등 당첨 기준 및 상금 확인")
    void 삼등_당첨_기준은_숫자가_5개_일치하고_상금이_1500000이다() {
        assertEquals(5, LottoRank.THIRD.getMatchCount());
        assertEquals(false, LottoRank.THIRD.isMatchBonus());
        assertEquals(1_500_000, LottoRank.THIRD.getPrize());
    }

    @Test
    @DisplayName("4등 당첨 기준 및 상금 확인")
    void 사등_당첨_기준은_숫자가_4개_일치하고_상금이_50000이다() {
        assertEquals(4, LottoRank.FOURTH.getMatchCount());
        assertEquals(false, LottoRank.FOURTH.isMatchBonus());
        assertEquals(50_000, LottoRank.FOURTH.getPrize());
    }

    @Test
    @DisplayName("5등 당첨 기준 및 상금 확인")
    void 오등_당첨_기준은_숫자가_3개_일치하고_상금이_5000이다() {
        assertEquals(3, LottoRank.FIFTH.getMatchCount());
        assertEquals(false, LottoRank.FIFTH.isMatchBonus());
        assertEquals(5_000, LottoRank.FIFTH.getPrize());
    }
}
