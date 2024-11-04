package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("첫 번째 순위인 경우")
    @Test
    void 첫번째순위_테스트() {
        LottoRank rank = LottoRank.valueOf(6, false);
        assertEquals(LottoRank.FIRST, rank);
    }

    @DisplayName("두 번째 순위인 경우")
    @Test
    void 두번째순위_테스트() {
        LottoRank rank = LottoRank.valueOf(5, true);
        assertEquals(LottoRank.SECOND, rank);
    }

    @DisplayName("세 번째 순위인 경우")
    @Test
    void 세번째순위_테스트() {
        LottoRank rank = LottoRank.valueOf(5, false);
        assertEquals(LottoRank.THIRD, rank);
    }

    @DisplayName("네 번째 순위인 경우")
    @Test
    void 네번째순위_테스트() {
        LottoRank rank = LottoRank.valueOf(4, false);
        assertEquals(LottoRank.FOURTH, rank);
    }

    @DisplayName("다섯 번째 순위인 경우")
    @Test
    void 다섯번째순위_테스트() {
        LottoRank rank = LottoRank.valueOf(3, false);
        assertEquals(LottoRank.FIFTH, rank);
    }

    @DisplayName("일치하는 번호가 없는 경우")
    @Test
    void 일치번호없는경우_테스트() {
        LottoRank rank = LottoRank.valueOf(0, false);
        assertEquals(LottoRank.NONE, rank);
    }

    @DisplayName("보너스 번호가 일치하는 경우")
    @Test
    void 보너스번호일치경우_테스트() {
        LottoRank rank = LottoRank.valueOf(0, true);
        assertEquals(LottoRank.NONE, rank);
    }

    @DisplayName("첫 번째 순위의 상금 확인")
    @Test
    void 첫번째순위상금확인_테스트() {
        assertEquals(2_000_000_000, LottoRank.FIRST.getPrize());
    }

    @DisplayName("두 번째 순위의 상금 확인")
    @Test
    void 두번째순위상금확인_테스트() {
        assertEquals(30_000_000, LottoRank.SECOND.getPrize());
    }

    @DisplayName("세 번째 순위의 상금 확인")
    @Test
    void 세번째순위상금확인_테스트() {
        assertEquals(1_500_000, LottoRank.THIRD.getPrize());
    }

    @DisplayName("네 번째 순위의 상금 확인")
    @Test
    void 네번째순위상금확인_테스트() {
        assertEquals(50_000, LottoRank.FOURTH.getPrize());
    }

    @DisplayName("다섯 번째 순위의 상금 확인")
    @Test
    void 다섯번째순위상금확인_테스트() {
        assertEquals(5_000, LottoRank.FIFTH.getPrize());
    }

    @DisplayName("일치하지 않는 경우의 상금 확인")
    @Test
    void 일치하지않는경우상금확인_테스트() {
        assertEquals(0, LottoRank.NONE.getPrize());
    }

    @DisplayName("첫 번째 순위의 일치 수 확인")
    @Test
    void 첫번째순위일치수확인_테스트() {
        assertEquals(6, LottoRank.FIRST.getMatchCount());
    }

    @DisplayName("두 번째 순위의 일치 수 확인")
    @Test
    void 두번째순위일치수확인_테스트() {
        assertEquals(5, LottoRank.SECOND.getMatchCount());
    }
}