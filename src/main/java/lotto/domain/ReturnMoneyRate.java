package lotto.domain;

import java.util.Map;

public class ReturnMoneyRate {
    public int calculateSum(Map<Integer, Integer> result) {
        int sum = 0;
        for (int key : result.keySet()) {
            sum += key * result.get(key);
        }
        return sum;
    }

    public double calculateRate(int sum, int money) {
        return ((double) sum / money)* 100;
    }
}
