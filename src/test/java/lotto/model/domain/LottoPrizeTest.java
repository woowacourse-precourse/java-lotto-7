package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {
    @Test
    public void 로또_보상_1등_계산_테스트() throws Exception {
        testLottoPrize(6, false, 1, LottoRank.FIRST);
    }

    @Test
    public void 로또_보상_2등_계산_테스트() throws Exception {
        testLottoPrize(5, true, 2, LottoRank.SECOND);
    }

    @Test
    public void 로또_보상_3등_계산_테스트() throws Exception {
        testLottoPrize(5, false, 3, LottoRank.THIRD);
    }

    @Test
    public void 로또_보상_4등_계산_테스트() throws Exception {
        testLottoPrize(4, false, 4, LottoRank.FOURTH);
        testLottoPrize(4, true, 4, LottoRank.FOURTH);
    }

    @Test
    public void 로또_보상_5등_계산_테스트() throws Exception {
        testLottoPrize(3, false, 5, LottoRank.FIFTH);
        testLottoPrize(3, true, 5, LottoRank.FIFTH);
    }

    @Test
    public void 로또_보상_없는_경우_계산_테스트() throws Exception {
        testLottoPrize(2, false, 0, LottoRank.DEFAULT);
        testLottoPrize(1, false, 0, LottoRank.DEFAULT);
        testLottoPrize(0, false, 0, LottoRank.DEFAULT);
        testLottoPrize(2, false, 0, LottoRank.DEFAULT);
        testLottoPrize(2, true, 0, LottoRank.DEFAULT);
        testLottoPrize(1, true, 0, LottoRank.DEFAULT);
        testLottoPrize(0, true, 0, LottoRank.DEFAULT);
    }

    private void testLottoPrize(int matchNumberCount, boolean isMatchBonus, int expectedRank, LottoRank expectedPrize)
            throws Exception {
        // given
        LottoPrize lottoPrize = new LottoPrize();

        // when
        lottoPrize.updateReward(matchNumberCount, isMatchBonus);

        // then
        Map<Integer, Integer> rewardRankResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            rewardRankResult.put(lottoRank.getRank(), 0);
        }
        rewardRankResult.put(expectedRank, 1);

        assertEquals(lottoPrize.getRewardPrizeResult(), expectedPrize.getPrize());
        assertEquals(lottoPrize.getRewardRankResult(), rewardRankResult);
    }
}