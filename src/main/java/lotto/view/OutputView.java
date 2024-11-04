package lotto.view;

import java.util.List;
import lotto.message.RunMessage;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printLottoCount(int amount) {
        System.out.printf(RunMessage.PRINT_LOTTO_COUNT.getMessage(), amount);
    }

    public static void printWinningStatisticsMessage(double yield) {
        System.out.print(RunMessage.PRINT_WINNING_STATISTIC_MESSAGE.getMessage());
        System.out.printf(RunMessage.PRINT_WINNING_FIFTH.getMessage(), Ranking.FIFTH.getCount());
        System.out.printf(RunMessage.PRINT_WINNING_FOURTH.getMessage(), Ranking.FOURTH.getCount());
        System.out.printf(RunMessage.PRINT_WINNING_THIRD.getMessage(), Ranking.THIRD.getCount());
        System.out.printf(RunMessage.PRINT_WINNING_SECOND.getMessage(), Ranking.SECOND.getCount());
        System.out.printf(RunMessage.PRINT_WINNING_FIRST.getMessage(), Ranking.FIRST.getCount());
        System.out.printf(RunMessage.PRINT_WINNING_STATISTIC.getMessage(), yield);
    }
}
