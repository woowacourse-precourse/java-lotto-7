package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("ENUM의 findRankByMatching 메서드 매칭 테스트")
    void ENUM_메서드와_매칭되는_ENUM이_있는_경우_테스트() {
        assertEquals(LottoRank.SIX_MATCH, LottoRank.findRankByMatching(6, false));
        assertEquals(LottoRank.FIVE_MATCH_BONUS, LottoRank.findRankByMatching(5, true));
        assertEquals(LottoRank.FIVE_MATCH, LottoRank.findRankByMatching(5, false));
        assertEquals(LottoRank.FOUR_MATCH, LottoRank.findRankByMatching(4, false));
        assertEquals(LottoRank.THREE_MATCH, LottoRank.findRankByMatching(3, false));

    }
    @Test
    @DisplayName("ENUM의 findRankByMatching 메서드와 매칭 Enum이 없는 경우 테스트")
    void ENUM_메서드와_매칭되는_ENUM이_없는_경우_테스트() {
        assertEquals(LottoRank.MISS, LottoRank.findRankByMatching(0, true)); // 3개 미만일 때는 MISS
        assertEquals(LottoRank.MISS, LottoRank.findRankByMatching(0, false));
        assertEquals(LottoRank.MISS, LottoRank.findRankByMatching(1, true));
        assertEquals(LottoRank.MISS, LottoRank.findRankByMatching(1, false));
        assertEquals(LottoRank.MISS, LottoRank.findRankByMatching(2, true));
        assertEquals(LottoRank.MISS, LottoRank.findRankByMatching(2, false));
    }
}