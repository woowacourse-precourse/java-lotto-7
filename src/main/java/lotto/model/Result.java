package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private final static int THREE_MATCHING_INDEX = 0;
    private final static int FOUR_MATCHING_INDEX = 1;
    private final static int FIVE_MATCHING_INDEX = 2;
    private final static int BONUS_MATCHING_INDEX = 3;
    private final static int SIX_MATCHING_INDEX = 4;

    private final List<Integer> results;
    private double rate;

    public Result() {
        results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    }

    public void put(long matchingCount, UserLotto userLotto, BonusNumber bonusNumber) {
        int bonus = bonusNumber.getNumber();
        if (matchingCount == 3) {
            results.set(THREE_MATCHING_INDEX, results.get(THREE_MATCHING_INDEX) + 1);
            return;
        }
        if (matchingCount == 4) {
            results.set(FOUR_MATCHING_INDEX, results.get(FOUR_MATCHING_INDEX) + 1);
            return;
        }
        if (matchingCount == 5) {
            if (userLotto.getUserNumber().contains(bonus)) {
                results.set(BONUS_MATCHING_INDEX, results.get(BONUS_MATCHING_INDEX) + 1);
                return;
            }
            results.set(FIVE_MATCHING_INDEX, results.get(FIVE_MATCHING_INDEX) + 1);
            return;
        }
        if (matchingCount == 6) {
            results.set(SIX_MATCHING_INDEX, results.get(SIX_MATCHING_INDEX) + 1);
        }
    }

    public void calculateRate(UserLottos userLottos) {
        rate =  roundOff((getProfit() / (double) getInvestmentCost(userLottos)) * 100);
    }

    private double roundOff(double number) {
        return Math.round(number * 10) / 10.0;
    }

    private long getInvestmentCost(UserLottos userLottos) {
        return userLottos.getPurchaseAmount();
    }

    private long getProfit() {
        return 5000L * results.get(THREE_MATCHING_INDEX) + 50000L * results.get(FOUR_MATCHING_INDEX) + 1500000L * results.get(FIVE_MATCHING_INDEX) + 30000000L * results.get(BONUS_MATCHING_INDEX) + 2000000000L * results.get(SIX_MATCHING_INDEX);
    }

    public double getRate(){
        return rate;
    }

    public List<Integer> getResult(){
        return results;
    }
}
