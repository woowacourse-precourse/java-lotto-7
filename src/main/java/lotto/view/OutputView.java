package lotto.view;

import static lotto.view.OutputMessage.SHOW_PURCHASE_COUNT;
import static lotto.view.OutputMessage.SHOW_SEPARATOR_LINE;
import static lotto.view.OutputMessage.SHOW_STATISTICS_INTRO;
import static lotto.view.OutputMessage.SHOW_TOTAL_PROFIT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Profit;

public class OutputView {
    public static void printPurchasedResult(Money money, List<Lotto> lottos) {
        printPurchasedCount(money.getMoney());
        lottos.forEach(OutputView::printLottoNumbers);
    }

    private static void printPurchasedCount(int money) {
        printNewLine();
        System.out.printf(SHOW_PURCHASE_COUNT.getMessage(), money);
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult(LottoResult lottoResult, Profit profit) {
        printNewLine();
        printLottoHead();
        printWinningResult(lottoResult);
        printProfit(profit);
    }

    private static void printLottoHead() {
        System.out.println(SHOW_STATISTICS_INTRO.getMessage());
        System.out.println(SHOW_SEPARATOR_LINE.getMessage());
    }

    private static void printWinningResult(LottoResult lottoResult) {
        System.out.println(OutputMessage.makeResultFormat(lottoResult.calculateRankDistribution()));
    }

    private static void printProfit(Profit profit) {
        System.out.printf(String.format(SHOW_TOTAL_PROFIT.getMessage(), profit.calculateProfit()));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
