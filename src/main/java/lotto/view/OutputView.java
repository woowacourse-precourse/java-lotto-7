package lotto.view;

import java.util.Map;
import lotto.constant.LottoConstants;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;

public class OutputView {
    public static void printPurchaseMessage(int lottoCount) {
        System.out.println("\n" + lottoCount + LottoConstants.PURCHASE_MESSAGE);
    }

    public static void printLottos(LottoTicket lottoTicket) {
        lottoTicket.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningStatistics(Map<LottoResult, Integer> lottoResultCount) {
        System.out.println(LottoConstants.WINNING_STATISTICS_HEADER);
        System.out.println(LottoConstants.WINNING_STATISTICS_DIVIDER);
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult == LottoResult.FIVE_BONUS) {
                printBonusStatistics(lottoResult, lottoResultCount);
                continue;
            }
            printRegularStatistics(lottoResult, lottoResultCount);
        }
    }

    private static void printBonusStatistics(LottoResult lottoResult, Map<LottoResult, Integer> lottoResultCount) {
        System.out.printf(LottoConstants.BONUS_STATISTICS_FORMAT,
                lottoResult.getMatchCount(), lottoResult.getPrizeMoney(),
                lottoResultCount.getOrDefault(lottoResult, 0));
    }

    private static void printRegularStatistics(LottoResult lottoResult, Map<LottoResult, Integer> lottoResultCount) {
        System.out.printf(LottoConstants.REGULAR_STATISTICS_FORMAT, lottoResult.getMatchCount(),
                lottoResult.getPrizeMoney(), lottoResultCount.getOrDefault(lottoResult, 0));
    }

    public static void printRateEarning(double rateEarning) {
        System.out.printf(LottoConstants.RATE_EARNING_MESSAGE, rateEarning);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
