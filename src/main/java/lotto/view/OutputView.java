package lotto.view;

import lotto.common.message.OutputMessage;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

import static lotto.common.message.OutputMessage.RESULT_MESSAGES;

public class OutputView {

    public static void printPurchaseResult(List<Lotto> lottos) {
        System.out.print(lottos.size());
        System.out.println(OutputMessage.PURCHASE_RESULT_MESSAGE.getMessage());

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatisticsResult(Map<String, Integer> results) {
        System.out.println(OutputMessage.STATISTICS_INFO_MESSAGE.getMessage());

        RESULT_MESSAGES.forEach((key, message) ->
                System.out.printf("%s %d개%n", message, results.getOrDefault(key, 0))
        );

    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("%s %.1f%%%s%n",
                OutputMessage.PROFIT_RATE_PREFIX_MESSAGE.getMessage(), profitRate, OutputMessage.PROFIT_RATE_SUFFIX_MESSAGE.getMessage()
        );
    }
}
