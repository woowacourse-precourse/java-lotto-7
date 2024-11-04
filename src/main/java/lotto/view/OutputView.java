package lotto.view;

import lotto.constants.OutputViewConstant;
import lotto.model.Winning;
import lotto.model.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public String resultToString(double revenueRate) {
        StringBuilder sb = new StringBuilder();
        double roundRevenueRate = getRoundRevenueRate(revenueRate);
        sb.append(OutputViewConstant.RESULT_HEADER);
        Arrays.stream(Winning.values()).forEach(winning -> sb.append(winning.toString()));
        sb.append(String.format(OutputViewConstant.REVENUE_RATE_MESSAGE, revenueRate));

        return sb.toString();
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbersToString());
        }
        System.out.println();
    }

    private double getRoundRevenueRate(double revenueRate) {
        return Math.round(revenueRate * 100) / 100.0;
    }
}
