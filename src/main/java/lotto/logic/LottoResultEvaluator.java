package lotto.logic;

import static lotto.constants.RankNumber.FIFTH;
import static lotto.constants.RankNumber.FIRST;
import static lotto.constants.RankNumber.FIRST_PRIZE_MONEY;
import static lotto.constants.RankNumber.FIVE;
import static lotto.constants.RankNumber.FOUR;
import static lotto.constants.RankNumber.FOURTH;
import static lotto.constants.RankNumber.FOURTH_PRIZE_MONEY;
import static lotto.constants.RankNumber.SECOND;
import static lotto.constants.RankNumber.SECOND_PRIZE_MONEY;
import static lotto.constants.RankNumber.SIX;
import static lotto.constants.RankNumber.THIRD;
import static lotto.constants.RankNumber.THIRD_PRIZE_MONEY;
import static lotto.constants.RankNumber.THREE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.input.Bonus;
import lotto.input.Lotto;
import lotto.input.Purchase;

public class LottoResultEvaluator {

    private static final int ZERO = 0;
    private Map<Integer, Integer> result;
    private int profit;
    private double returnRate;

    public LottoResultEvaluator() {
        this.result = new HashMap<>();
    }

    public void evaluateLottoResults(Lotto winningNumber, LottoNumbersGenerator lottos, Bonus bonus, Purchase purchase) {
        result.clear();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> copyLotto = getCopyLotto(winningNumber, lotto);
            getFirstRank(copyLotto);
            getSecondRank(lotto, copyLotto, bonus);
            getThirdRank(lotto, copyLotto, bonus);
            getFourthRank(copyLotto);
            getFifthRank(copyLotto);
        }
        this.profit = getProfitMoney(this.result);
        this.returnRate = calculateRate(this.profit, purchase);
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public int getProfit() {
        return profit;
    }

    public double getReturnRate() {
        return returnRate;
    }

    private static List<Integer> getCopyLotto(Lotto winningNumber, Lotto lotto) {
        List<Integer> copyLotto = new ArrayList<>(lotto.getNumbers());
        copyLotto.retainAll(winningNumber.getNumbers());
        return copyLotto;
    }

    private void getFirstRank(List<Integer> copyLotto) {
        if (copyLotto.size() == SIX.getNumber()) {
            result.put(FIRST.getNumber(), result.getOrDefault(FIRST.getNumber(), 0) + 1);
        }
    }

    private void getSecondRank(Lotto lotto, List<Integer> copyLotto, Bonus bonus) {
        if (copyLotto.size() == FIVE.getNumber() && lotto.getNumbers().contains(bonus.getBonus())) {
            result.put(SECOND.getNumber(), result.getOrDefault(SECOND.getNumber(), 0) + 1);
        }
    }

    private void getThirdRank(Lotto lotto, List<Integer> copyLotto, Bonus bonus) {
        if (copyLotto.size() == FIVE.getNumber() && !lotto.getNumbers().contains(bonus.getBonus())) {
            result.put(THIRD.getNumber(), result.getOrDefault(THIRD.getNumber(), 0) + 1);
        }
    }

    private void getFourthRank(List<Integer> copyLotto) {
        if (copyLotto.size() == FOUR.getNumber()) {
            result.put(FOURTH.getNumber(), result.getOrDefault(FOURTH.getNumber(), 0) + 1);
        }
    }

    private void getFifthRank(List<Integer> copyLotto) {
        if (copyLotto.size() == THREE.getNumber()) {
            result.put(FIFTH.getNumber(), result.getOrDefault(FIFTH.getNumber(), 0) + 1);
        }
    }

    private int getProfitMoney(Map<Integer, Integer> result) {
        int money = 0;
        money += get1stMoney(result.getOrDefault(FIRST, 0));
        money += get2ndMoney(result.getOrDefault(SECOND, 0));
        money += get3thMoney(result.getOrDefault(THIRD, 0));
        money += get4thMoney(result.getOrDefault(FOURTH, 0));
        money += get5thMoney(result.getOrDefault(FIFTH, 0));

        return money;
    }

    private int get1stMoney(int count) {
        if (count != ZERO) {
            return FIRST_PRIZE_MONEY.getNumber() * count;
        }
        return 0;
    }

    private int get2ndMoney(int count) {
        if (count != ZERO) {
            return SECOND_PRIZE_MONEY.getNumber() * count;
        }
        return 0;
    }

    private int get3thMoney(int count) {
        if (count != ZERO) {
            return THIRD_PRIZE_MONEY.getNumber() * count;
        }
        return 0;
    }

    private int get4thMoney(int count) {
        if (count != ZERO) {
            return FOURTH_PRIZE_MONEY.getNumber() * count;
        }
        return 0;
    }

    private int get5thMoney(int count) {
        if (count != ZERO) {
            return FIFTH.getNumber() * count;
        }
        return 0;
    }

    private double calculateRate(int profit, Purchase purchase) {
        return Math.round((((double) profit / purchase.getPurchase() * 100) * 10) / 10.0);
    }
}
