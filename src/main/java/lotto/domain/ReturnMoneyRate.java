package lotto.domain;

import java.util.Map;

public class ReturnMoneyRate {
    public int calculateSum(Map<String, Integer> result) {
        int sum = 0;
        for (int winningMoney : result.values()) {
            sum += winningMoney;
        }
        return sum;
    }

    public int calculateRate(int sum, int money) {
        return (sum / money)* 100;
    }
}
