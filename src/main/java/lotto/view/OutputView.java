package lotto.view;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Won;
import lotto.dto.LottoPaper;
import lotto.dto.RankResult;

public class OutputView {

    private static final List<Rank> PRINT_RANKS = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    private static final String SECOND_RANK_MESSAGE_PATTERN = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String DEFAULT_RANK_MESSAGE_PATTERN = "%d개 일치 (%s원) - %d개\n";

    public static void renderPaper(LottoPaper paper) {
        printPurchaseCount(paper);
        printLottos(paper);
        printEmptySpace();
    }

    private static void printPurchaseCount(LottoPaper paper) {
        System.out.printf("%d개를 구매했습니다.\n", paper.count());
    }

    private static void printLottos(LottoPaper paper) {
        for (Lotto lotto : paper.getLottos()) {
            List<Integer> lottoNumbers = lotto.toIntList();
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public static void renderStatistics(LottoPaper lottoPaper, RankResult ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRanks(ranks);
        printYield(lottoPaper, ranks);
    }

    private static void printRanks(RankResult ranks) {
        NumberFormat currencyFormat = NumberFormat.getNumberInstance();
        for (Rank rank : PRINT_RANKS) {
            System.out.printf(findPattern(rank), rank.count(), currencyFormat.format(rank.price()), ranks.count(rank));
        }
    }

    private static String findPattern(Rank rank) {
        if (Rank.SECOND.equals(rank)) {
            return SECOND_RANK_MESSAGE_PATTERN;
        }
        return DEFAULT_RANK_MESSAGE_PATTERN;
    }

    private static void printYield(LottoPaper lottoPaper, RankResult ranks) {
        NumberFormat yieldFormat = yieldFormat();

        System.out.printf("총 수익률은 %s%%입니다.\n", yieldFormat.format(calcPercentage(lottoPaper, ranks)));
    }

    private static NumberFormat yieldFormat() {
        NumberFormat yieldFormat = NumberFormat.getNumberInstance();
        yieldFormat.setMaximumFractionDigits(1);
        yieldFormat.setMinimumFractionDigits(1);
        return yieldFormat;
    }

    private static double calcPercentage(LottoPaper lottoPaper, RankResult ranks) {
        Won profit = ranks.totalProfit();
        Won purchasePrice = lottoPaper.purchasePrice();
        return profit.divide(purchasePrice) * 100;
    }

    public static void renderError(String message) {
        System.out.printf("[ERROR] %s\n", message);
        printEmptySpace();
    }

    private static void printEmptySpace() {
        System.out.println();
    }
}
