package lotto.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrize {
    private final Map<Integer, Integer> rewardRankResult;
    private long rewardPrizeResult;

    public LottoPrize() {
        this.rewardRankResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            this.rewardRankResult.put(lottoRank.getRank(), 0);
        }
        this.rewardPrizeResult = 0;
    }

    public Map<Integer, Integer> getRewardRankResult() {
        return rewardRankResult;
    }

    public long getRewardPrizeResult() {
        return rewardPrizeResult;
    }

    public void updateReward(int matchNumberCount, boolean isMatchBonus) {
        int rewardRank = 0;
        
        // LottoRank 열거형의 초기화 된 순서로 인해 reverse 작업 진행
        List<LottoRank> ranks = new ArrayList<>(Arrays.asList(LottoRank.values()));
        Collections.reverse(ranks);

        for (LottoRank lottoRank : ranks) {
            rewardRank = checkRank(lottoRank, matchNumberCount, isMatchBonus);
            if(rewardRank != 0) {
                break;
            }
        }
        updatePrizeResult(rewardRank);
        updateRankResult(rewardRank);
    }

    private void updatePrizeResult(int rewardRank) {
        rewardPrizeResult += LottoRank.findByRank(rewardRank).getPrize();
    }

    private void updateRankResult(int rewardRank) {
        int plusOneRewardRankResult = rewardRankResult.get(rewardRank)+1;
        rewardRankResult.put(rewardRank, plusOneRewardRankResult);
    }

    private int checkRank(LottoRank lottoRank, int matchNumberCount, boolean isMatchBonus) {
        if (lottoRank.getMatchCount() == matchNumberCount) {
            if (!lottoRank.isConfirmBonus() || lottoRank.isRequiredBonus() == isMatchBonus) {
                return lottoRank.getRank();
            }
        }
        return LottoRank.DEFAULT.getRank();
    }
}