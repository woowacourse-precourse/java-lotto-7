package lotto.model.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoPrize {
    private Map<Integer, Integer> rewardRankResult;
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

    public void updateReward(int matchNumberCount, boolean matchBonusCount) {
        int rewardRank = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            rewardRank = checkRank(lottoRank, matchNumberCount, matchBonusCount);
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

    private int checkRank(LottoRank lottoRank, int matchNumberCount, boolean matchBonusCount) {
        if (lottoRank.getMatchCount() == matchNumberCount) {
            if (lottoRank.isConfirmBonus() && lottoRank.isRequiredBonus()== matchBonusCount) {
                return lottoRank.getRank();
            }
            return lottoRank.getRank();
        }
        return LottoRank.DEFAULT.getRank();
    }
}