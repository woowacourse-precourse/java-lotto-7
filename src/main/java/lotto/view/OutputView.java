package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public static void printInitialMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyingLotto(int lottoAmount) {
        System.out.println("\n" + lottoAmount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(
            lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX))
        );
    }

    public static void printMessageDefaultLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printMessageBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(List<String> messages, List<Integer> prizes, List<Integer> counts) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (int i = 0; i < messages.size(); i++) {
            printStatistic(messages.get(i), prizes.get(i), counts.get(i));
        }
    }

    private static void printStatistic(String message, int prize, int count) {
        System.out.printf("%s (%,d원) - %d개%n", message, prize, count);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
