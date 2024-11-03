package lotto;

import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final String MATCHING_COUNT_UNIT = "개";
    private static final String WINNING_DETAIL_DELIMITER = "\n";

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
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Winning, Integer> entry : winningDetails.entrySet()) {
            result.append(entry.getKey().getPrintFormat());
            result.append(entry.getValue() + MATCHING_COUNT_UNIT);
            result.append(WINNING_DETAIL_DELIMITER);
        }
        return result.toString();
    }

    public void calculate(WinningNumber winningNumber, BonusNumber bonusNumber, PurchasedLotto purchasedLotto) {
        for(Lotto lotto : purchasedLotto.get()) {
            List<Integer> purchasedLottoNumber = new ArrayList<>(lotto.get());
            boolean isBonusContained = purchasedLottoNumber.contains(bonusNumber.get());

            purchasedLottoNumber.retainAll(winningNumber.get());
            int matchingCount = purchasedLottoNumber.size();

            Winning satisfiedWinning = getSatisfiedWinning(matchingCount, isBonusContained);
            if(satisfiedWinning != null) {
                winningDetails.put(satisfiedWinning, winningDetails.get(satisfiedWinning) + 1);
            }
        }
    }

    public long calculateTotalPrize() {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> entry.getKey()
                        .calculatePrize(entry.getValue()))
                .sum();
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
