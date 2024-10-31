package lotto.model;

import java.util.EnumMap;

public class RankResult {

    private EnumMap<Rank, Integer> ranks;

    public RankResult(EnumMap<Rank, Integer> map) {
        this.ranks = map;
    }

    public Float calculateReturnRate(Long totalLottoPrice) {
        Long winningAmount = calculateWinningAmount();
        return (Float.valueOf(winningAmount) / totalLottoPrice) * 100;
    }

    public Long calculateWinningAmount() {
        Long sum = 0L;
        Integer firstCount = this.ranks.getOrDefault(Rank.FIRST, 0);
        sum += firstCount * Rank.FIRST.getPrize();
        Integer secondCount = this.ranks.getOrDefault(Rank.SECOND, 0);
        sum += secondCount * Rank.SECOND.getPrize();
        Integer thirdCount = this.ranks.getOrDefault(Rank.THIRD, 0);
        sum += thirdCount * Rank.THIRD.getPrize();
        Integer fourthCount = this.ranks.getOrDefault(Rank.FOURTH, 0);
        sum += fourthCount * Rank.FOURTH.getPrize();
        Integer fifthCount = this.ranks.getOrDefault(Rank.FIFTH, 0);
        sum += fifthCount * Rank.FIFTH.getPrize();

        return sum;
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개";
    }

    public int getMatchCount(Rank rank) {
        return this.ranks.get(rank);
    }
}
