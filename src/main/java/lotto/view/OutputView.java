package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_COUNT_PROMPT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_PROMPT = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String TOTAL_RETURN_PROMPT = "총 수익률은 ";
    private static final String PERCENT_SYMBOL = "%입니다.";

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

        printPrize(FIFTH_PRIZE_MESSAGE, result.getFifthPrizeCount());
        printPrize(FOURTH_PRIZE_MESSAGE, result.getFourthPrizeCount());
        printPrize(THIRD_PRIZE_MESSAGE, result.getThirdPrizeCount());
        printPrize(SECOND_PRIZE_MESSAGE, result.getSecondPrizeCount());
        printPrize(FIRST_PRIZE_MESSAGE, result.getFirstPrizeCount());

        System.out.printf("%s%.1f%s%n", TOTAL_RETURN_PROMPT, result.getProfitRate(), PERCENT_SYMBOL);
    }

    private static void printPrize(String prizeMessage, int count) {
        System.out.println(prizeMessage + count + "개");
    }
}
