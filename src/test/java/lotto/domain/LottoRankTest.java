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
}