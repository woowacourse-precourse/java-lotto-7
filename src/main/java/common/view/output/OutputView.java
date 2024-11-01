package common.view.output;

import domain.Buyer;
import domain.Rank;
import domain.Settlement;
import common.view.ViewMessage;
import java.util.Map;

public class OutputView {

    public static void printLottoNumber(Buyer buyer) {
        System.out.println(ViewMessage.PURCHASE_CONFIRMATION_MESSAGE.format(buyer.getQuantity()));
        System.out.println(buyer);
        System.out.println();
    }

    public static void printWinningHistory(Settlement settlement) {
        System.out.println(ViewMessage.WINNING_STATISTIC_MESSAGE);
        Map<Rank, Integer> detail = settlement.getWinningDetails();

        for (Rank rank : Rank.values()) {

            if (rank == Rank.NOTHING) continue;

            int count = detail.getOrDefault(rank, 0);
            if (rank == Rank.SECOND_PLACE) {
                System.out.println(ViewMessage.WINNING_BONUS_DETAIL_MESSAGE
                        .format(rank.getMatchedCount(), rank.getWinningAmount(), count));
                continue;
            }
            System.out.println(ViewMessage.WINNING_DETAIL_MESSAGE
                    .format(rank.getMatchedCount(), rank.getWinningAmount(), count));
        }

        System.out.println(settlement.getProfitRate());
    }

}
