package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.validation.ValidatorImpl.ZERO;

public class LottoResult {
    public static final int ONE = 1;
    private final Map<Rank, Integer> rankCount;

    public LottoResult() {
        rankCount = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(rank -> rank, rank -> ZERO));
    }

    public void addRank(Rank rank) {
        if (rank != null) {
            rankCount.put(rank, rankCount.get(rank) + ONE);
        }
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public int calculateTotalPrizeMoney() {
        return rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        appendRank(result, Rank.FIFTH, "3개 일치 (5,000원)");
        appendRank(result, Rank.FOURTH, "4개 일치 (50,000원)");
        appendRank(result, Rank.THIRD, "5개 일치 (1,500,000원)");
        appendRank(result, Rank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        appendRank(result, Rank.FIRST, "6개 일치 (2,000,000,000원)");
        return result.toString();
    }

    private void appendRank(StringBuilder result, Rank rank, String description) {
        result.append(description)
                .append(" - ")
                .append(rankCount.getOrDefault(rank, ZERO))
                .append("개\n");
    }
}