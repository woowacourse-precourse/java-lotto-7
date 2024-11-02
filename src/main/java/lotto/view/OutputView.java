package lotto.view;

import lotto.domain.LottoRank;
import lotto.util.Formatter;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    public static void printPurchaseLottos(Integer count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public static void printIssueAllLottoNumbers(List<List<Integer>> allLottoNumbers) {
        allLottoNumbers.forEach(System.out::println);
    }

    public static void inputWinLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.FAIL) {
                continue;
            }
            printLottoRankResult(result, rank);
        }
    }

    private static void printLottoRankResult(Map<LottoRank, Integer> result, LottoRank rank) {
        System.out.printf("%d개 일치", rank.getMatchedCount());
        if (rank.isBonusNumber()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.printf(" (%s원) - %d개%n", Formatter.formatToCurrency(rank.getPrize()), result.getOrDefault(rank, 0));
    }

    public static void printLottoReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }
}
