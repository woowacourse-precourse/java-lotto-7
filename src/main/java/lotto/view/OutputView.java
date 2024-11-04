package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private OutputView() {
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                System.out.printf("%s - %d개\n", rank.getDescription(), statistics.getOrDefault(rank, 0));
            }
        }
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", returnRate);
    }
}