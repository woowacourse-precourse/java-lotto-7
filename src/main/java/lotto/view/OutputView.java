package lotto.view;

import lotto.constants.view.OutputViewMessage;
import lotto.model.Winning;
import lotto.model.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public String resultToString(double revenueRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(OutputViewMessage.RESULT_HEADER);
        Arrays.stream(Winning.values()).forEach(winning -> sb.append(winning.toString()));
        sb.append(String.format(OutputViewMessage.REVENUE_RATE_MESSAGE, revenueRate));

        return sb.toString();
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.numbersToString());
        }
        System.out.println();
    }
}
