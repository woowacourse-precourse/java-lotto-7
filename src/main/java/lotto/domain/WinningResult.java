package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {

    private final Map<LottoRank, Integer> lottoScore;

    public WinningResult() {
        this.lottoScore = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            lottoScore.put(rank, 0);
        }
    }

    public int getRankScore(LottoRank rank) {
        return lottoScore.get(rank);
    }

    public void increaseRankScore(LottoRank rank) {
        lottoScore.put(rank, getRankScore(rank) + 1);
    }


    public long sumTotalReward() {
        long sum = 0L;
        for (LottoRank lottoRank : lottoScore.keySet()) {
            sum += lottoRank.getReward() * lottoScore.get(lottoRank);
        }
        return sum;
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        return (sumTotalReward() / (double) purchaseAmount) * 100;
    }

    @Override
    public String toString() {
        return lottoScore.keySet().stream()
                .filter(lottoRank -> !lottoRank.equals(LottoRank.NONE)) // 낙첨은 제외
                .map(lottoRank -> String.format(
                        "%s (%,d원) - %d개",
                        lottoRank.getDescription(),
                        lottoRank.getReward(),
                        lottoScore.getOrDefault(lottoRank, 0)
                ))
                .collect(Collectors.joining("\n"));
    }
}
