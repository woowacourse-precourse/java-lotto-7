package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {
    private static OutputView instance;
    private static final String PURCHASE_SIZE_INFO = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTIC = "\n당첨 통계";
    private static final String DASH_BAR = "---";
    private static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - %d개%n";
    private static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - %d개%n";
    private static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - %d개%n";
    private static final String FIVE_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
    private static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개%n";
    private static final String YIELD_INFO = "총 수익률은 %.1f%%입니다.%n";

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }

        return instance;
    }

    public void printPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf(PURCHASE_SIZE_INFO, lottoTickets.size());
        lottoTickets.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningResults(int price, Map<Rank, Integer> winCount) {
        System.out.println(WINNING_STATISTIC);
        System.out.println(DASH_BAR);

        System.out.printf(THREE_MATCH_MESSAGE, winCount.get(Rank.FIFTH_PLACE));
        System.out.printf(FOUR_MATCH_MESSAGE, winCount.get(Rank.FOURTH_PLACE));
        System.out.printf(FIVE_MATCH_MESSAGE, winCount.get(Rank.THIRD_PLACE));
        System.out.printf(FIVE_BONUS_MATCH_MESSAGE, winCount.get(Rank.SECOND_PLACE));
        System.out.printf(SIX_MATCH_MESSAGE, winCount.get(Rank.FIRST_PLACE));

        printStatistic(winCount, price);
    }

    private void printStatistic(Map<Rank, Integer> winCount, int price) {
        int totalPrizeMoney = (winCount.get(Rank.FIFTH_PLACE) * Rank.FIFTH_PLACE.getPrize()) +
                (winCount.get(Rank.FOURTH_PLACE) * Rank.FIRST_PLACE.getPrize()) +
                (winCount.get(Rank.THIRD_PLACE) * Rank.THIRD_PLACE.getPrize()) +
                (winCount.get(Rank.SECOND_PLACE) * Rank.SECOND_PLACE.getPrize()) +
                (winCount.get(Rank.FIRST_PLACE) * Rank.FIRST_PLACE.getPrize());

        double yield = (double) totalPrizeMoney / price * 100;
        System.out.printf(YIELD_INFO, yield);
    }
}
