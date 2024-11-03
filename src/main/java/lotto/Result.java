package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<WinningCondition, Integer> winningDetails = new LinkedHashMap<>();

    public Result() {
        for(WinningCondition winningCondition : WinningCondition.values()) {
            winningDetails.put(winningCondition, 0);
        }
    }

    public Map<WinningCondition, Integer> getWinningDetails() {
        return Collections.unmodifiableMap(winningDetails);
    }

    public String getFormattedWinningDetails() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<WinningCondition, Integer> entry : winningDetails.entrySet()) {
            result.append(entry.getKey().getPrintFormat());
            result.append(entry.getValue() + "개");
            result.append("\n");
        }
        return result.toString();
    }

    public void calculate(WinningNumber winning, BonusNumber bonus, PurchasedLotto purchasedLotto) {
        List<Integer> winningNumbers = winning.getNumbers();
        int bonusNumber = bonus.getValue();
        List<Lotto> purchasedLottos = purchasedLotto.get();

        for(Lotto lotto : purchasedLottos) {
            List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
            boolean isBonusContained = lottoNumbers.contains(bonusNumber);

            lottoNumbers.retainAll(winningNumbers);
            int matchingCount = lottoNumbers.size();

            WinningCondition satisfiedWinningCondition = getSatisfiedWinningCriteria(matchingCount, isBonusContained);
            if(satisfiedWinningCondition != null) {
                winningDetails.put(satisfiedWinningCondition, winningDetails.get(satisfiedWinningCondition) + 1);
            }
        }
    }

    public long calculateTotalPrize() {
        return winningDetails.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrize(entry.getValue()))
                .sum();
    }

    private WinningCondition getSatisfiedWinningCriteria(int matchingCount, boolean isBonusContained) {
        if (matchingCount == 6) {
            return WinningCondition.FIRST;
        }
        if (matchingCount == 5 && isBonusContained) {
            return WinningCondition.SECOND;
        }
        if (matchingCount == 5) {
            return WinningCondition.THIRD;
        }
        if (matchingCount == 4) {
            return WinningCondition.FOURTH;
        }
        if (matchingCount == 3) {
            return WinningCondition.FIFTH;
        }
        return null;
    }
}
