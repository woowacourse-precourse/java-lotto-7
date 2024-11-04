package lotto.domain;

import java.util.List;
import lotto.global.LottoRank;

public class UserWinningLottosInfo {
    private final List<LottoRank> ranks;
    private final int price;

    public UserWinningLottosInfo(List<LottoRank> ranks, int price) {
        this.price = price;
        this.ranks = ranks;
    }

    public int getWinningCountByLottoRank(LottoRank lottoRank) {
        return ranks.stream()
                .filter(rank -> rank == lottoRank)
                .mapToInt(rank -> 1)
                .sum();
    }

    public double getProfitRate() {
        int profit = ranks.stream()
                .mapToInt(LottoRank::getPrize)
                .sum();
        return myRound((float) profit / price);
    }

    private double myRound(double profit) {
        return Math.round(profit * 1000) / 10.0;
    }
}
