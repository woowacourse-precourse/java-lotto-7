package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.PrizeTier;

public class OutputView {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    public void printLottoPurchase(List<Lotto> purchasedTickets) {
        System.out.printf(ViewMessage.LOTTO_COUNT_PURCHASED.getMessage(), purchasedTickets.size());
        System.out.println();
        purchasedTickets.forEach(ticket -> System.out.println(ticket.formatNumbers()));
    }

    public void printWinningResults(Map<PrizeTier, Integer> prizeCounts) {
        System.out.println(ViewMessage.RESULT_HEADER.getMessage());

        System.out.print(formatPrizeMessage(ViewMessage.SIX_MATCH, prizeCounts.getOrDefault(PrizeTier.FIRST, 0),
                PrizeTier.FIRST.getPrizeAmount()));
        System.out.print(formatPrizeMessage(ViewMessage.FIVE_MATCH_BONUS, prizeCounts.getOrDefault(PrizeTier.SECOND, 0),
                PrizeTier.SECOND.getPrizeAmount()));
        System.out.print(formatPrizeMessage(ViewMessage.FIVE_MATCH, prizeCounts.getOrDefault(PrizeTier.THIRD, 0),
                PrizeTier.THIRD.getPrizeAmount()));
        System.out.print(formatPrizeMessage(ViewMessage.FOUR_MATCH, prizeCounts.getOrDefault(PrizeTier.FOURTH, 0),
                PrizeTier.FOURTH.getPrizeAmount()));
        System.out.print(formatPrizeMessage(ViewMessage.THREE_MATCH, prizeCounts.getOrDefault(PrizeTier.FIFTH, 0),
                PrizeTier.FIFTH.getPrizeAmount()));
    }

    public void printProfitRate(double profitRate) {
        System.out.println(ViewMessage.PROFIT_RATE.formatProfitRate(profitRate));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private String formatPrizeMessage(ViewMessage message, int count, int prizeAmount) {
        return String.format(message.getMessage(), numberFormat.format(prizeAmount), count);
    }
}
