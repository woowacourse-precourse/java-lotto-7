package lotto.view;

import static lotto.view.OutputMessage.ASK_BONUS_NUMBER;
import static lotto.view.OutputMessage.ASK_PURCHASE_PRICE;
import static lotto.view.OutputMessage.ASK_WINNING_NUMBER;
import static lotto.view.OutputMessage.SHOW_PURCHASE_COUNT;
import static lotto.view.OutputMessage.SHOW_SEPARATOR_LINE;
import static lotto.view.OutputMessage.SHOW_STATISTICS_INTRO;
import static lotto.view.OutputMessage.SHOW_TOTAL_PROFIT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.exception.InputException;

public class OutputView {
    public static void askPurchasePrice() {
        System.out.println(ASK_PURCHASE_PRICE.getMessage());
    }

    public static void askWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER.getMessage());
    }

    public static void askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER.getMessage());
    }

    public static void printPurchasedResult(int ticketCount, List<Lotto> lottos) {
        printPurchasedCount(ticketCount);
        printNewLine();
        lottos.forEach(OutputView::printLottoNumbers);
    }

    private static void printPurchasedCount(int ticketCount) {
        printNewLine();
        System.out.printf(SHOW_PURCHASE_COUNT.getMessage(), ticketCount);
    }

    private static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
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
        System.out.printf(SHOW_TOTAL_PROFIT.getMessage(), profit.calculateProfit());
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printErrorMessage(InputException exception) {
        System.out.println(exception.getMessage());
    }
}
