package lotto.view.output;

import static lotto.util.LottoConstants.DEFAULT;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.Profit;
import lotto.domain.Rank;

public class OutputView {

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printPurchasePrice() {
        System.out.println(OutputMessage.INPUT_PURCHASE_PRICE.message);
    }

    public static void printPurchasedLottery(LottoShop lottoShop, LottoCount lottoCount) {
        printLine();
        System.out.printf(OutputMessage.PURCHASED_COUNT.message, lottoCount.getCount());
        printLine();
        List<Lotto> lotteries = lottoShop.getLottoTickets().getLotteries();

        lotteries.stream().map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printWinningNumbers() {
        System.out.println(OutputMessage.INPUT_WINNING_NUMBERS.message);
    }

    public static void printBonusNumber() {
        System.out.println(OutputMessage.INPUT_BONUS_NUMBER.message);
    }

    public static void printWinningStatics() {
        printLine();
        System.out.print(OutputMessage.WINNING_STATISTICS.message);
    }

    public static void printMatchNumber(LottoResult lottoResult, int bonusNumber) {
        Map<Rank, Integer> rankCount = lottoResult.getMatchNumber();
        for (Rank rank : Rank.values()) {
            int matchCount = rankCount.getOrDefault(rank, DEFAULT.getValue());
            System.out.printf(rank.getMessage(), matchCount);
            printLine();
        }
    }

    public static void printTotalProfit(LottoResult lottoResult, LottoCount lottoCount) {
        Profit profit = new Profit(lottoResult, lottoCount);
        System.out.printf(OutputMessage.PROFIT.message, profit.calculateTotalProfit());
    }
}
