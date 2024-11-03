package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.PrizeTier;

public class OutputView {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    public void printLottoPurchase(List<Lotto> purchasedTickets) {
        printPurchaseCount(purchasedTickets.size());
        printTicketNumbers(purchasedTickets);
    }

    public void printWinningResults(Map<PrizeTier, Integer> prizeCounts) {
        printResultsHeader();
        printAllPrizeCounts(prizeCounts);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(ViewMessage.PROFIT_RATE.getMessage(), profitRate);
    }


    private void printPurchaseCount(int count) {
        System.out.printf(ViewMessage.LOTTO_COUNT_PURCHASED.getMessage(), count);
    }

    private void printTicketNumbers(List<Lotto> tickets) {
        tickets.forEach(ticket -> System.out.println(ticket.formatNumbers()));
    }

    private void printResultsHeader() {
        System.out.println(ViewMessage.RESULT_HEADER.getMessage());
    }

    private void printAllPrizeCounts(Map<PrizeTier, Integer> prizeCounts) {
        printPrizeCount(ViewMessage.SIX_MATCH, PrizeTier.MATCH_SIX, prizeCounts);
        printPrizeCount(ViewMessage.FIVE_MATCH_BONUS, PrizeTier.MATCH_FIVE_WITH_BONUS, prizeCounts);
        printPrizeCount(ViewMessage.FIVE_MATCH, PrizeTier.MATCH_FIVE, prizeCounts);
        printPrizeCount(ViewMessage.FOUR_MATCH, PrizeTier.MATCH_FOUR, prizeCounts);
        printPrizeCount(ViewMessage.THREE_MATCH, PrizeTier.MATCH_THREE, prizeCounts);
    }

    private void printPrizeCount(ViewMessage message, PrizeTier tier, Map<PrizeTier, Integer> prizeCounts) {
        int count = prizeCounts.getOrDefault(tier, 0);
        System.out.printf(message.getMessage(), numberFormat.format(tier.getPrizeAmount()), count);
    }

}
