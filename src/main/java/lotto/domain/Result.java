package lotto.domain;

import java.util.HashMap;
import lotto.constant.Prize;

public class Result {
    private HashMap<Prize, Integer> prizeResult;
    private long totalPrize;

    public Result() {
        initResult();
    }

    private void initResult() {
        this.prizeResult = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeResult.put(prize, 0);
        }
        this.totalPrize = 0;
    }

    public void addPrize(Prize prize) {
        Integer prevCount = prizeResult.getOrDefault(prize, 0);
        prizeResult.put(prize, prevCount + 1);
        totalPrize += prize.getMoney();
    }

    public HashMap<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public long getTotalPrize() {
        return totalPrize;
    }
}
