package lotto.Model;

import java.util.Map;

public class Rate {
    public int CalculateSum(Map<Integer, Integer> result) {
        int sum = 0;
        for (int key : result.keySet()) {
            sum += key * result.get(key);
        }
        return sum;
    }

    public double CalculateRate(int sum, int money) {
        return ((double) sum / money)* 100;
    }
}
