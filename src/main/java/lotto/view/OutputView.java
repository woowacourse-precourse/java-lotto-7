package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.util.Rank;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_COUNT_PROMPT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_PROMPT = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String TOTAL_RETURN_PROMPT = "총 수익률은 ";
    private static final String PERCENT_SYMBOL = "%입니다.";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";

    public static void printLottos(List<Lotto> lottos) {
        int purchasedQuantity = lottos.size();
        System.out.println(purchasedQuantity + PURCHASE_COUNT_PROMPT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(LottoResult result) {
        System.out.println(WINNING_STATISTICS_PROMPT);
        System.out.println(HYPHEN);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) continue;
            printPrize(rank, result.getPrizeCount(rank));
        }

        System.out.printf("%s%.1f%s%n", TOTAL_RETURN_PROMPT, result.getProfitRate(), PERCENT_SYMBOL);
    }

    private static void printPrize(Rank rank, int count) {
        String bonusMessage = "";
        if (rank.isRequiresBonus()) {
            bonusMessage = BONUS_MESSAGE;
        }
        System.out.printf("%d개 일치%s (%s원) - %d개%n", rank.getMatchCount(), bonusMessage, String.format("%,d", rank.getPrize()), count);
    }
}
