package lotto.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    private static final String COUNT_LOTTO = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String LINE = "---";
    private static final String LOTTO_RESULT = "%d개 일치 (%s원) - %d개";
    private static final String LOTTO_RESULT_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RETURN_RATE = "총 수익률은 %.1f%%입니다.";

    public static void printLotties(List<List<Integer>> lottoNums) {
        System.out.printf(COUNT_LOTTO + "\n", lottoNums.size());

        for (List<Integer> lottoNum : lottoNums) {
            System.out.println(lottoNum);
        }
        System.out.println();
    }

    public static void printWinningDetails(Map<Integer, Integer> results) {
        System.out.println(WINNING_STATISTIC);
        System.out.println(LINE);

        System.out.printf(LOTTO_RESULT + "\n", 3, "5,000", results.getOrDefault(5, 0));
        System.out.printf(LOTTO_RESULT + "\n", 4, "50,000", results.getOrDefault(4, 0));
        System.out.printf(LOTTO_RESULT + "\n", 5, "1,500,000", results.getOrDefault(3, 0));
        System.out.printf(LOTTO_RESULT_BONUS + "\n", 5, "30,000,000", results.getOrDefault(2, 0));
        System.out.printf(LOTTO_RESULT + "\n", 6, "2,000,000,000", results.getOrDefault(1, 0));
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf(RETURN_RATE, returnRate);
    }

    public static void printErrorMessage(String message){
        System.out.println("[ERROR] " + message);
    }
}
