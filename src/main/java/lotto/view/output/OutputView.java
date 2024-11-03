package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
import lotto.domain.Profit;
import lotto.domain.Rank;

public class OutputView {
    private static final int DEFAULT = 0;
    private static final String NEW_LINE = "%n";

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
        System.out.println();
        System.out.printf(OutputMessage.PURCHASED_COUNT.message, lottoCount.getCount());
        System.out.println();
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
        System.out.println();
        System.out.print(OutputMessage.WINNING_STATISTICS.message);
    }

    public static void printMatchNumber(LottoResult lottoResult, int bonusNumber) {
        Map<Rank, Integer> rankCount = lottoResult.getMatchNumber();
        for (Rank rank : Rank.values()) {
            int matchCount = rankCount.getOrDefault(rank, DEFAULT);
            System.out.printf(rank.getMessage() + NEW_LINE, matchCount);
        }
    }

    public static void printTotalProfit(LottoResult lottoResult, LottoCount lottoCount) {
        Profit profit = new Profit(lottoResult, lottoCount);
        System.out.printf(OutputMessage.PROFIT.message, profit.calculateTotalProfit());
    }
}
