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

    public double calculateRate(int sum, int money) {
        return ((double) sum / money)* 100;
    }
}
