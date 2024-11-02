package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoRankTest {

    private final boolean BONUS_MATCH = true;
    private final boolean NO_BONUS_MATCH = false;

    @Test
    public void 로또_1등_테스트() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(6, NO_BONUS_MATCH);
        assertEquals(LottoRank.FIRST, rank);
    }

    @Test
    public void 로또_2등_테스트() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(5, BONUS_MATCH);
        assertEquals(LottoRank.SECOND, rank);
    }

    @Test
    public void 로또_3등_테스트() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(5, NO_BONUS_MATCH);
        assertEquals(LottoRank.THIRD, rank);
    }

    @Test
    public void 로또_4등_테스트() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(4, NO_BONUS_MATCH);
        assertEquals(LottoRank.FOURTH, rank);
    }

    @Test
    public void 로또_5등_테스트() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(3, NO_BONUS_MATCH);
        assertEquals(LottoRank.FIFTH, rank);
    }

    @Test
    public void 로또_꽝_테스트() {
        LottoRank rank = LottoRank.findByMatchCountAndBonus(2, NO_BONUS_MATCH);
        assertEquals(LottoRank.OTHER, rank);
    }

    @Test
    public void 로또_상금_출력() {
        assertEquals(2_000_000_000, LottoRank.FIRST.getPrizeAmount());
        assertEquals(30_000_000, LottoRank.SECOND.getPrizeAmount());
        assertEquals(1_500_000, LottoRank.THIRD.getPrizeAmount());
        assertEquals(50_000, LottoRank.FOURTH.getPrizeAmount());
        assertEquals(5_000, LottoRank.FIFTH.getPrizeAmount());
        assertEquals(0, LottoRank.OTHER.getPrizeAmount());
    }

    @Test
    public void 로또_상금_메세지_출력() {
        assertEquals("6개 일치 (2,000,000,000원)", LottoRank.FIRST.getRankMessage());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", LottoRank.SECOND.getRankMessage());
        assertEquals("5개 일치 (1,500,000원)", LottoRank.THIRD.getRankMessage());
        assertEquals("4개 일치 (50,000원)", LottoRank.FOURTH.getRankMessage());
        assertEquals("3개 일치 (5,000원)", LottoRank.FIFTH.getRankMessage());
        assertEquals("꽝", LottoRank.OTHER.getRankMessage());
    }

}