package lotto;

import static lotto.Constants.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private static final String WINNING_DETAIL_FORMAT = "%s%d개\n";

    private final Map<Rank, Integer> winningDetails;

    public Result() {
        this.winningDetails = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            winningDetails.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getWinningDetails() {
        return Collections.unmodifiableMap(winningDetails);
    }

    public String getFormattedWinningDetails() {
        return winningDetails.entrySet().stream()
                .map(entry -> getFormattedWinningDetail(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    public void calculate(Winning winning, Bonus bonus, PurchasedLotto purchasedLottos) {
        for(Lotto purchasedLotto : purchasedLottos.get()) {
            int matchingCount = purchasedLotto.getMatchingCountWith(winning);
            boolean isBonusContained = purchasedLotto.isContained(bonus);
            addWinningDetails(matchingCount, isBonusContained);
        }
    }

    public long calculateTotalPrize() {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> entry.getKey()
                        .calculatePrize(entry.getValue()))
                .sum();
    }

    private String getFormattedWinningDetail(Rank condition, Integer count) {
        return String.format(WINNING_DETAIL_FORMAT, condition.getPrintFormat(), count);
    }

    private void addWinningDetails(int matchingCount, boolean isBonusContained) {
        Rank satisfiedRank = getSatisfiedRank(matchingCount, isBonusContained);
        if(satisfiedRank != null) {
            winningDetails.put(satisfiedRank, winningDetails.get(satisfiedRank) + 1);
        }
    }

    private Rank getSatisfiedRank(int matchingCount, boolean isBonusContained) {
        if (matchingCount == FIRST_MATCHING_COUNT) return Rank.FIRST;
        if (matchingCount == SECOND_MATCHING_COUNT && isBonusContained) return Rank.SECOND;
        if (matchingCount == THIRD_MATCHING_COUNT) return Rank.THIRD;
        if (matchingCount == FOURTH_MATCHING_COUNT) return Rank.FOURTH;
        if (matchingCount == FIFTH_MATCHING_COUNT) return Rank.FIFTH;
        return null;
    }
}
