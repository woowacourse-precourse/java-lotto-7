package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요";
    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS_HEADER = "당첨통계";
    private static final String STATISTICS_DIVIDER = "'---";
    private static final String LOTTO_BOUGHT_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS_MESSAGE = "%s (%s) - %d개\n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void requestMoney() {
        System.out.println(REQUEST_MONEY);
    }

    public static void printLottos(List<Lotto> lottos) {
        printNumberOfLotto(lottos);
        for (Lotto lotto : lottos) {
            printNumbers(lotto.getNumbers());
        }
    }

    private static void printNumberOfLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_BOUGHT_MESSAGE);
    }

    public static void printNumbers(List<Integer> numbers) {
        String result = "[" + numbers.stream()
                .map(String::valueOf).
                collect(Collectors.joining(", ")) + "]";
        System.out.println(result);
    }

    public static void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public static void printStastistics(Map<String, Integer> statistics) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);
        printResultInfo(statistics, Result.FIFTH);
        printResultInfo(statistics, Result.FOURTH);
        printResultInfo(statistics, Result.THIRD);
        printResultInfo(statistics, Result.SECOND);
        printResultInfo(statistics, Result.FIRST);
    }

    private static void printResultInfo(Map<String, Integer> statistics, Result nResult) {
        System.out.printf(STATISTICS_MESSAGE, nResult.message, printFormattedAmount(nResult.winningAmount), statistics.getOrDefault(nResult.message, 0));
    }

    private static String printFormattedAmount(int amount) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        return formatter.format(amount) + "원";
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
