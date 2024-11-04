package lotto.view;

import lotto.constants.view.OutputViewMessage;
import lotto.model.Winning;
import lotto.model.draw_numbers.DrawNumbers;
import lotto.model.lotto.Lotto;
import lotto.model.payment.Payment;

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

    public long printLottoCount(Payment payment) {
        long lottoCount = payment.calcLottoCount();
        System.out.println(String.format(OutputViewMessage.LOTTO_COUNT_MESSAGE, lottoCount));
        return lottoCount;
    }
}
