package lotto.presentation.view;

import java.util.Comparator;
import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeCategory;

import java.util.List;


 //사용자 출력을 담당하는 클래스
public class LottoOutputView {

    public void displayErrorMessage(String message) {
        System.out.println(message);
    }

    public void displayPurchasedTickets(List<Lotto> tickets) {
        System.out.println(OutputMessages.PURCHASED_TICKETS_MESSAGE.format(tickets.size()));
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    public void displayWinningStatistics(List<PrizeCategory> prizeCategories, int[] prizeCounts) {
        System.out.println(OutputMessages.WINNING_STATISTICS_HEADER.getMessage());
        System.out.println("---");

        List<PrizeCategory> sortedCategories = prizeCategories.stream()
                .sorted(Comparator.comparingInt(PrizeCategory::getMatchCount))
                .toList();

        for (PrizeCategory category : sortedCategories) {
            int count = prizeCounts[category.ordinal()];
            String message = (category == PrizeCategory.SECOND)
                    ? OutputMessages.BONUS_MATCH_STATISTICS.format(category.getMatchCount(), formatCurrency(category.getPrize()), count)
                    : OutputMessages.MATCH_STATISTICS.format(category.getMatchCount(), formatCurrency(category.getPrize()), count);
            System.out.println(message);
        }
    }

    public void displayTotalProfitRate(double profitRate) {
        System.out.println(OutputMessages.TOTAL_PROFIT_RATE.format(profitRate));
    }

    private String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }
}