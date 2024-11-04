package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {

    private static final String NUMBER_OF_PURCHASE_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String RESULTS_ANNOUNCEMENT_MESSAGE = "당첨 통계";
    private static final String SEPARATING_LINE = "---";
    private static final String WINNING_DETAIL = "%s (%s원) - %d개";
    private static final String WINNING_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchases(int number, List<Lotto> lottos) {
        System.out.println(String.format(NUMBER_OF_PURCHASE_MESSAGE, number));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printResult(Lottos lottos) {
        System.out.println(RESULTS_ANNOUNCEMENT_MESSAGE);
        System.out.println(SEPARATING_LINE);

        lottos.getWinningStatistics().forEach((rank, count) -> {
            System.out.println(String.format(
                    WINNING_DETAIL,
                    rank.getDescription(),
                    rank.getPrize(),
                    count
            ));
        });

        System.out.println(String.format(WINNING_RATE_OF_RETURN_MESSAGE, lottos.getRateOfReturn()));
    }
}
