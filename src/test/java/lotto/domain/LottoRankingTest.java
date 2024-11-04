package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoRankingTest {
    @Test
    void 삼등을_잘_분류하는지_확인() {
        assertEquals(LottoRanking.getRank(5, false),
                LottoRanking.THIRD);
    }

    @Test
    void 이등_값을_줬을때_삼등으로_인식_하지_않는지_확인() {
        assertNotEquals(LottoRanking.getRank(5, true),
                LottoRanking.THIRD);
    }
}