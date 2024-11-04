package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import lotto.domain.WinningResult;

public class OutputView {

    private static final String PURCHASE_QUANTITY_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String STATISTICS_HEADER_MESSAGE = "당첨 통계\n---";
    private static final String PRIZE_FORMAT_MESSAGE = "%d개 일치%s (%,d원) - %d개\n";
    private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    private static final String PROFIT_RATE_FORMAT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseQuantity(final int quantity) {
        System.out.printf(PURCHASE_QUANTITY_MESSAGE, quantity);
    }

    public static void printLottos(final List<Lotto> lottos) {
        lottos.forEach(OutputView::printLotto);
        System.out.println();
    }

    public static void printLotto(final Lotto lotto) {
        String result = lotto.numbers().stream()
                .map(LottoNumber::number)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    public static void printWinningResult(final WinningResult result) {
        printStatisticsHeader();
        printPrizeResults(result);
        printProfitRate(result);
    }

    private static void printStatisticsHeader() {
        System.out.println(STATISTICS_HEADER_MESSAGE);
    }

    private static void printPrizeResults(final WinningResult result) {
        getPrizesByAscendingCount().forEach(prize ->
                printPrizeResult(prize, result));
    }

    private static List<Prize> getPrizesByAscendingCount() {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.MISS)
                .sorted(Comparator.comparing(Prize::getMatchCount))
                .toList();
    }

    private static void printPrizeResult(Prize prize, WinningResult result) {
        System.out.printf(PRIZE_FORMAT_MESSAGE,
                prize.getMatchCount(),
                getBonusMatchText(prize),
                prize.getAmount(),
                result.countPrize(prize));
    }

    private static String getBonusMatchText(Prize prize) {
        if (prize.getNeedBonusMatch()) {
            return BONUS_MATCH_MESSAGE;
        }
        return "";
    }

    private static void printProfitRate(final WinningResult result) {
        System.out.printf(PROFIT_RATE_FORMAT_MESSAGE, result.getProfitRate());
    }
}
