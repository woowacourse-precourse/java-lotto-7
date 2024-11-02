package lotto.presentation.view;

import java.util.Comparator;
import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeCategory;

import java.util.List;

/**
 * 사용자 출력을 담당하는 LottoOutputView 클래스
 */
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

        // 낮은 일치 수부터 높은 일치 수로 정렬된 순서로 출력
        List<PrizeCategory> sortedCategories = prizeCategories.stream()
                .sorted(Comparator.comparingInt(PrizeCategory::getMatchCount)).toList();

        for (PrizeCategory category : sortedCategories) {
            int count = prizeCounts[category.ordinal()];
            if (category == PrizeCategory.SECOND) {
                System.out.println(OutputMessages.BONUS_MATCH_STATISTICS.format(category.getMatchCount(),
                        formatCurrency(category.getPrize()), count));
            } else {
                System.out.println(OutputMessages.MATCH_STATISTICS.format(category.getMatchCount(),
                        formatCurrency(category.getPrize()), count));
            }
        }
    }

    public void displayTotalProfitRate(double profitRate) {
        System.out.println(OutputMessages.TOTAL_PROFIT_RATE.format(profitRate));
    }

    /**
     * 숫자를 통화 형식(세자리마다 콤마)으로 변환합니다.
     *
     * @param amount 금액
     * @return 통화 형식의 문자열
     */
    private String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }
}
