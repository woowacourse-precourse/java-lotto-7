package lotto.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningPrize;

public class OutputView {
    public static void printException(IllegalArgumentException e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }

    public static void printPurchaseResult(Lottos purchasedLottos) {
        printPurchaseCount(purchasedLottos);
        printLottoNumbers(purchasedLottos);
    }

    private static void printPurchaseCount(Lottos purchasedLottos) {
        System.out.printf("\n%d개를 구매했습니다.", purchasedLottos.getSize());
    }

    private static void printLottoNumbers(Lottos purchasedLottos) {
        List<Lotto> lottos = purchasedLottos.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public static void printLottoResults(LottoResult lottoResult, double returnRate) {
        printResultHeader();
        printPrizeStatistics(lottoResult.getResults());
        printReturnRate(returnRate);
    }

    private static void printResultHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private static void printPrizeStatistics(Map<WinningPrize, Integer> results) {
        for (WinningPrize prize : WinningPrize.values()) {
            printValidPrizeResult(prize, results);
        }
    }

    private static void printValidPrizeResult(WinningPrize prize, Map<WinningPrize, Integer> results) {
        if (isValidPrize(prize)) {
            printPrizeResult(prize, results.get(prize));
        }
    }

    private static boolean isValidPrize(WinningPrize prize) {
        return prize != WinningPrize.NONE_PRIZE;
    }

    private static void printPrizeResult(WinningPrize prize, int count) {
        System.out.printf("%s (%,d원) - %d개%n",
                prize.getDescription(),
                prize.getPrize(),
                count);
    }

    private static void printReturnRate(double returnRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }
}
