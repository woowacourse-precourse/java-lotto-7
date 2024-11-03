package lotto.common.view.output;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.common.view.ViewMessage;
import java.text.NumberFormat;
import java.util.Map;

public class OutputView {

    public static void printLottoNumber(Lottos buyer) {
        System.out.println(ViewMessage.PURCHASE_CONFIRMATION_MESSAGE.format(buyer.getQuantity()));
        System.out.println(buyer);
        System.out.println();
    }

    public static void printWinningHistory(Map<Rank, Long> detail, double profitRate) {
        System.out.println(ViewMessage.WINNING_STATISTIC_MESSAGE);

        for (Rank rank : Rank.values()) {

            if (rank == Rank.NOTHING) {
                continue;
            }

            int matchedCount = rank.getMatchedCount();
            String amount = NumberFormat.getInstance().format(rank.getWinningAmount());
            long winningCount = detail.getOrDefault(rank, 0L);

            if (rank == Rank.SECOND_PLACE) {
                System.out.println(ViewMessage.WINNING_BONUS_DETAIL_MESSAGE
                        .format(matchedCount, amount, winningCount));
                continue;
            }
            System.out.println(ViewMessage.WINNING_DETAIL_MESSAGE
                    .format(matchedCount, amount, winningCount));
        }

        System.out.println(ViewMessage.TOTAL_REVENUE_RATE_MESSAGE.format(profitRate));
    }

    public static void printErrorMessage(String input) {
        System.out.println(input);
    }
}
