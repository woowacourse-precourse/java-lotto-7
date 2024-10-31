package lotto.logic;

import static lotto.constants.RankNumber.FIFTH;
import static lotto.constants.RankNumber.FIFTH_PRIZE_MONEY;
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

import java.util.List;
import java.util.Map;
import lotto.constants.RankNumber;
import lotto.input.Bonus;
import lotto.input.Lotto;
import lotto.input.Purchase;

public class LottoResultEvaluator {

    private Map<Integer, Integer> result;
    private int profit;
    private double returnRate;

    public LottoResultEvaluator(Lotto winningNumber, LottoNumbersGenerator lottos, Bonus bonus, Purchase purchase) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> copyLotto = lotto.getNumbers();
            copyLotto.retainAll(winningNumber.getNumbers());
            getFirstRank(copyLotto);
            getSecondRank(lotto, copyLotto, bonus);
            getThirdRank(copyLotto);
            getFourthRank(copyLotto);
            getFifthRank(copyLotto);
        }
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

    private void getThirdRank(List<Integer> copyLotto) {
        if (copyLotto.size() == FIVE.getNumber()) {
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
}
