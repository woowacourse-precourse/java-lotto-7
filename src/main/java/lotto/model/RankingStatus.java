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
        StringBuilder matchComment = new StringBuilder();
        matchComment
                .append(MatchComment.FIFTH_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.FIFTH)))
                .append("\n")
                .append(MatchComment.FOURTH_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.FOURTH)))
                .append("\n")
                .append(MatchComment.THIRD_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.THIRD)))
                .append("\n")
                .append(MatchComment.SECOND_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.SECOND)))
                .append("\n")
                .append(MatchComment.FIRST_LOTTO_MESSAGE.getComment(getRankingCount(Ranking.FIRST)))
                .append("\n");

        return matchComment.toString();
    }

    private int getRankingCount(Ranking ranking) {
        return rankingCounts.get(ranking);
    }
}
