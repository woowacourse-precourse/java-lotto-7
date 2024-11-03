package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;

public class OutputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
    }

    public static void printPurchaseLottoCount(int Count) {
        System.out.println(System.lineSeparator() + Count + PURCHASE_LOTTO_COUNT);
    }

    public static void printEachLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printWinningNumberInputMessage() {
        System.out.println(System.lineSeparator() + WINNING_NUMBER_INPUT);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(System.lineSeparator() + BONUS_NUMBER_INPUT);
    }

    public static void printWinningStatisticsMessage() {
        System.out.println(System.lineSeparator() + WINNING_STATISTICS);
    }

    public static void printResult(Map<Prize, Integer> lottoResult) {
        for (Prize prize : Prize.values()) {
            int count = lottoResult.getOrDefault(prize, 0);
            System.out.printf("%d개 일치%s (%d원) - %d개%n",
                    prize.getMatchCount(),
                    prize.isMatchBonus() ? ", 보너스 볼 일치" : "",
                    prize.getPrizeMoney(),
                    count);
        }
    }
    public static void printProfitRatio(double profitRatio) {
        System.out.printf("총 수익률은 %.1f%% 입니다.%n",profitRatio);
    }

}
