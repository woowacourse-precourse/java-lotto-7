package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Calculate;
import lotto.domain.DrawNumbers;

public class CalculateService {
    public List<Integer> calculatePrizeMoney(DrawNumbers winningNumbers, List<DrawNumbers> drawSets) {
        List<Integer> prizeMoneyGroup = new ArrayList<>();

        for (DrawNumbers drawNumber : drawSets) {
            Calculate calculate = new Calculate(winningNumbers, drawNumber);
            int prizeMoney = calculate.calculatePrizeMoney();
            prizeMoneyGroup.add(prizeMoney);
        }
        return prizeMoneyGroup;
    }

    public Double calculateProfitRatio(List<Integer> prizeMoneyGroup, int purchaseAmount) {
        int totalPrizeMoney = prizeMoneyGroup.stream().reduce(0, Integer::sum);
        double profitRatio = ((double) totalPrizeMoney / purchaseAmount) * 100;
        return Math.round(profitRatio * 10)/10.0;
    }
}
