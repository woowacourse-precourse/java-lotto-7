package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.Rank;

public class OutputView {

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
                .collect(Collectors.joining(", ", "[", "]"))
        );
    }

    public static void printMessageDefaultLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printMessageBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(Map<Rank, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        printStatistic(statistics, Rank.THREE);
        printStatistic(statistics, Rank.FOUR);
        printStatistic(statistics, Rank.FIVE);
        printStatistic(statistics, Rank.FIVE_AND_BONUS);
        printStatistic(statistics, Rank.SIX);
    }

    private static void printStatistic(Map<Rank, Integer> statistics, Rank rank) {
        int count = statistics.getOrDefault(rank, 0);
        String message = switch (rank) {
            case THREE -> "3개 일치";
            case FOUR -> "4개 일치";
            case FIVE -> "5개 일치";
            case FIVE_AND_BONUS -> "5개 일치, 보너스 볼 일치";
            case SIX -> "6개 일치";
        };
        System.out.printf("%s (%,d원) - %d개%n", message, rank.getPrize(), count);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}