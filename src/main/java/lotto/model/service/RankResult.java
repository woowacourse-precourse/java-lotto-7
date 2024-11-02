package lotto.model.service;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.model.domain.Rank;

public class RankResult {

    private static final String MATCH_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    private static final String MATCH_WITH_BONUS_FORMAT = "5개 일치, 보너스 볼 일치 (%,d원) - %d개%n";

    private EnumMap<Rank, Integer> rankResults;

    public RankResult() {
        EnumMap<Rank, Integer> rankResults = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankResults.put(rank, 0));
        rankResults.remove(Rank.NONE);

        this.rankResults = rankResults;
    }

    public Float calculateReturnRate(Long totalLottoPrice) {
        Long winningAmount = calculateWinningAmount();
        return (Float.valueOf(winningAmount) / totalLottoPrice) * 100;
    }

    public Long calculateWinningAmount() {
        Long sum = 0L;
        Integer firstCount = this.rankResults.getOrDefault(Rank.FIRST, 0);
        sum += firstCount * Rank.FIRST.getPrize();
        Integer secondCount = this.rankResults.getOrDefault(Rank.SECOND, 0);
        sum += secondCount * Rank.SECOND.getPrize();
        Integer thirdCount = this.rankResults.getOrDefault(Rank.THIRD, 0);
        sum += thirdCount * Rank.THIRD.getPrize();
        Integer fourthCount = this.rankResults.getOrDefault(Rank.FOURTH, 0);
        sum += fourthCount * Rank.FOURTH.getPrize();
        Integer fifthCount = this.rankResults.getOrDefault(Rank.FIFTH, 0);
        sum += fifthCount * Rank.FIFTH.getPrize();

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : rankResults.keySet()) {
            sb.append(formatRankResult(rank));
        }

        return sb.toString();
    }


    private String formatRankResult(Rank rank) {
        if (rank == Rank.SECOND) {
            return String.format(MATCH_WITH_BONUS_FORMAT,
                    rank.getMoney(),
                    rankResults.get(rank));
        }
        return String.format(MATCH_FORMAT,
                rank.getMatchCount(),
                rank.getMoney(),
                rankResults.get(rank));
    }

    protected EnumMap<Rank, Integer> getRankReuslts() {
        return this.rankResults;
    }

    public void increaseRankCount(Rank rank) {
        this.rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
    }
}
