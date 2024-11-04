package lotto.view;

import lotto.domain.Lotto;
import lotto.message.OutputMessage;
import lotto.message.ResultMessage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printIssueResults(List<Lotto> lottos) {
        OutputMessage.PRINT_PURCHASED_LOTTO_COUNT.printMessage(lottos.size());
        lottos.stream()
                .map(lotto -> lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .forEach(System.out::println);
    }

    public static void printWinningResults(Map<ResultMessage, Integer> winningResults) {
        OutputMessage.PRINT_RESULT_TITLE.printMessage();

        for (ResultMessage result : ResultMessage.values()) {
            int count = winningResults.getOrDefault(result, 0);
            result.printMessage(count);
        }
    }

    public static void printProfitRate(double calculateProfitRate) {
        OutputMessage.PRINT_TOTAL_PRICE_RATE.printMessage(calculateProfitRate);
    }
}
