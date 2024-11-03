package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoShop;
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

    public static void printPurchasedLottery(LottoShop lottoShop) {
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
        System.out.println(OutputMessage.WINNING_STATISTICS.message);
    }

    public static void printMatchNumber(LottoResult lottoResult) {
        Map<Integer, Integer> rankCount = lottoResult.getMatchNumber();
        for (Rank rank : Rank.values()) {
            int matchCount = rankCount.getOrDefault(rank.getMatchNumber(), 0);
            System.out.printf(rank.getMessage() + "%n", matchCount);
        }
    }
}
