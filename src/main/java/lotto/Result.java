package lotto;

import static lotto.Constants.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private static final String WINNING_DETAIL_FORMAT = "%s%d개\n";

    private final Map<Winning, Integer> winningDetails;

    public Result() {
        this.winningDetails = new LinkedHashMap<>();
        for (Winning winning : Winning.values()) {
            winningDetails.put(winning, 0);
        }
    }

    public Map<Winning, Integer> getWinningDetails() {
        return Collections.unmodifiableMap(winningDetails);
    }

    public String getFormattedWinningDetails() {
        return winningDetails.entrySet().stream()
                .map(entry -> getFormattedWinningDetail(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    public void calculate(WinningNumber winningNumber, BonusNumber bonusNumber, PurchasedLotto purchasedLottos) {
        for(Lotto purchasedLotto : purchasedLottos.get()) {
            int matchingCount = purchasedLotto.getMatchingCountWith(winningNumber);
            boolean isBonusContained = purchasedLotto.isContained(bonusNumber);
            addWinningDetails(matchingCount, isBonusContained);
        }
    }

    public long calculateTotalPrize() {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> entry.getKey()
                        .calculatePrize(entry.getValue()))
                .sum();
    }

    private String getFormattedWinningDetail(Winning condition, Integer count) {
        return String.format(WINNING_DETAIL_FORMAT, condition.getPrintFormat(), count);
    }

    private void addWinningDetails(int matchingCount, boolean isBonusContained) {
        Winning satisfiedWinning = getSatisfiedWinning(matchingCount, isBonusContained);
        if(satisfiedWinning != null) {
            winningDetails.put(satisfiedWinning, winningDetails.get(satisfiedWinning) + 1);
        }
    }

    private Winning getSatisfiedWinning(int matchingCount, boolean isBonusContained) {
        if (matchingCount == FIRST_MATCHING_COUNT) return Winning.FIRST;
        if (matchingCount == SECOND_MATCHING_COUNT && isBonusContained) return Winning.SECOND;
        if (matchingCount == THIRD_MATCHING_COUNT) return Winning.THIRD;
        if (matchingCount == FOURTH_MATCHING_COUNT) return Winning.FOURTH;
        if (matchingCount == FIFTH_MATCHING_COUNT) return Winning.FIFTH;
        return null;
    }
}
