package lotto.view;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningPrize;
import lotto.global.message.OutputMessage;

public class OutputView {
    public static void printNewEmptyLine() {
        System.out.print(OutputMessage.NEW_LINE);
    }

    public static void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchaseResult(Lottos purchasedLottos) {
        printPurchaseCount(purchasedLottos);
        printLottoNumbers(purchasedLottos);
    }

    private static void printPurchaseCount(Lottos purchasedLottos) {
        printNewEmptyLine();
        System.out.printf(OutputMessage.PURCHASE_COUNT_FORMAT, purchasedLottos.getSize());
        printNewEmptyLine();
    }

    private static void printLottoNumbers(Lottos purchasedLottos) {
        List<Lotto> lottos = purchasedLottos.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
        printNewEmptyLine();
    }

    public static void printLottoResults(LottoResult lottoResult, double returnRate) {
        printResultHeader();
        printPrizeStatistics(lottoResult.getResults());
        printReturnRate(returnRate);
    }

    private static void printResultHeader() {
        printNewEmptyLine();
        System.out.println(OutputMessage.STATISTICS_HEADER);
        System.out.println(OutputMessage.STATISTICS_DELIMITER);
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
        System.out.printf(OutputMessage.PRIZE_RESULT_FORMAT,
                prize.getDescription(),
                prize.getPrize(),
                count);
    }

    private static void printReturnRate(double returnRate) {
        System.out.printf(OutputMessage.RETURN_RATE_FORMAT, returnRate);
    }
}
