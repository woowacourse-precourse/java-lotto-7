package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.WinningStatus;

public class OutputView {

    public static final String LOTTO_RESULT_STATISTICS_MESSAGE = "당첨 통계";
    public static final String STATISTICS_LINE_DELIMITER = "---";
    public static final String COUNT_UNIT_MESSAGE = "개";
    public static final String WINNINGSTATUS_COUNT_DELIMITER = " - ";
    private static final String LOTTO_PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    public static final String DECIMAL_FORMAT = "#,##0.0";

    public void printPurchaseAmount(int lottoQuantity) {
        System.out.println();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> numbers){
        String sortedNumber = numbers.stream()
                .sorted()
                .toList()
                .toString();
        System.out.println(sortedNumber);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printResult(Map<WinningStatus, Integer> result) {
        System.out.println();
        System.out.println(LOTTO_RESULT_STATISTICS_MESSAGE);
        System.out.println(STATISTICS_LINE_DELIMITER);
        for (WinningStatus status : result.keySet()) {
            System.out.println(status.getDescription() + WINNINGSTATUS_COUNT_DELIMITER + result.get(status) + COUNT_UNIT_MESSAGE);
        }
    }

    public void printProfit(double profit) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        System.out.printf(LOTTO_PROFIT_MESSAGE, decimalFormat.format(profit));
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
