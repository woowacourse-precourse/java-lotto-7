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
        purchasedTickets.forEach(ticket -> System.out.println(ticket.formatNumbers()));
    }

    public void printWinningResults(Map<PrizeTier, Integer> prizeCounts) {
        System.out.println(ViewMessage.RESULT_HEADER.getMessage());
        printPrizeCount(ViewMessage.SIX_MATCH, PrizeTier.MATCH_SIX, prizeCounts);
        printPrizeCount(ViewMessage.FIVE_MATCH_BONUS, PrizeTier.MATCH_FIVE_WITH_BONUS, prizeCounts);
        printPrizeCount(ViewMessage.FIVE_MATCH, PrizeTier.MATCH_FIVE, prizeCounts);
        printPrizeCount(ViewMessage.FOUR_MATCH, PrizeTier.MATCH_FOUR, prizeCounts);
        printPrizeCount(ViewMessage.THREE_MATCH, PrizeTier.MATCH_THREE, prizeCounts);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(ViewMessage.PROFIT_RATE.getMessage(), profitRate);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printPrizeCount(ViewMessage message, PrizeTier tier, Map<PrizeTier, Integer> prizeCounts) {
        int count = prizeCounts.getOrDefault(tier, 0);
        System.out.printf(message.getMessage(), numberFormat.format(tier.getPrizeAmount()), count);
    }

}
