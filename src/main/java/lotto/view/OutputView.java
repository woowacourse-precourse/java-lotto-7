package lotto.view;

import static lotto.message.MessageConstants.OUTPUT_PURCHASE_COUNT_MESSAGE;
import static lotto.message.MessageConstants.OUTPUT_WINNING_STATISTICS_HEADER;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printLottoPurchaseCountMessage(int lottoCount) {
        System.out.printf(OUTPUT_PURCHASE_COUNT_MESSAGE, lottoCount);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printWinningStatisticsHeader() {
        System.out.println(OUTPUT_WINNING_STATISTICS_HEADER);
    }

    public void printWinningStatisticsMessage(String message, int prizeMoney, int count) {
        System.out.printf(message, NumberFormat.getInstance().format(prizeMoney), count);
    }

    public void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }

}
