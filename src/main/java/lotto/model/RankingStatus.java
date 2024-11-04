package lotto.model;

import java.util.EnumMap;

public class RankingStatus {
    private final EnumMap<Ranking, Integer> rankingCounts;

    public RankingStatus() {
        rankingCounts = new EnumMap<>(Ranking.class);

        for (Ranking value : Ranking.values()) {
            rankingCounts.put(value, 0);
        }
    }

    public void updateRankStatus(Ranking ranking) {
        rankingCounts.put(ranking, rankingCounts.get(ranking) + 1);
    }

    public long getTotalPrize() {
        return rankingCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney(entry.getValue()))
                .sum();
    }

    public String makeMatchComment() {
        return MatchComment.FIFTH_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.FIFTH)) +
                "\n" +
                MatchComment.FOURTH_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.FOURTH)) +
                "\n" +
                MatchComment.THIRD_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.THIRD)) +
                "\n" +
                MatchComment.SECOND_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.SECOND)) +
                "\n" +
                MatchComment.FIRST_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.FIRST)) +
                "\n";
    }

    private int getRankingCount(Ranking ranking) {
        return rankingCounts.get(ranking);
    }
}
