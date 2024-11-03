package lotto.view;

import java.util.List;
import lotto.model.LottoPurchaseResult;

public class ResultFormatter {
    private static final String AMOUNT_POSTFIX = "개를 구매했습니다.";
    private static final String NEW_LINE = "\n";

    public String formatLottoPurchaseResult(LottoPurchaseResult lottoPurchaseResult) {
        StringBuilder formattedResult = new StringBuilder();
        formattedResult.append(formatAmount(lottoPurchaseResult.amount()));
        lottoPurchaseResult.lottoTicketsNumbers().forEach(numbers ->
                formattedResult.append(formatNumbers(numbers))
        );

        return formattedResult.toString();
    }

    private String formatAmount(int amount) {
        return amount + AMOUNT_POSTFIX + NEW_LINE;
    }

    private String formatNumbers(List<Integer> numbers) {
        return numbers.toString() + NEW_LINE;
    }
}
