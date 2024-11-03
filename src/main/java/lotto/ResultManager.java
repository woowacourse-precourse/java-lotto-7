package lotto;

import java.util.List;

public class ResultManager {
    private List<Integer> winningNumbers;
    private int bonus;
    private double profit = 0;
    public ResultManager(List<Integer> winningNumbers, int bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }
    public double analyzeResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int collect = lotto.countCollect(winningNumbers);
            Result result = getResult(collect, lotto);
            if (result != null) {
                result.incrementCount();
                profit += result.getPrice();
            }
        }
        return profit;
    }
    public Result getResult(int collect, Lotto lotto) {
        if (collect == 3) {
            return Result.Three;
        }
        if (collect == 4) {
            return Result.Four;
        }
        if (collect == 5) {
            if (lotto.getNumbers().contains(bonus)) {
                return Result.Bonus;
            }
            if (lotto.getNumbers().contains(bonus)) {
                return Result.Five;
            }
        }
        if (collect == 6) {
            return Result.Six;
        }
        return null;
    }
}
