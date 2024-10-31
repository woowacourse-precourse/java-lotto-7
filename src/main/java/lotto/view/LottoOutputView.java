package lotto.view;

import lotto.Lotto;
import lotto.common.LottoConstant;

import java.util.List;

public class LottoOutputView {

    private static final String lineSeparator = System.getProperty("line.separator");
    private static final String PURCHASE_ANNOUNCEMENT = "%d개를 구매했습니다.";
    private static final String OUTPUT_WINNING_STATISTICS_BEFORE = "당첨 통계" + lineSeparator + "---";
    private static final String OUTPUT_FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개";
    private static final String OUTPUT_SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String OUTPUT_THIRD_PLACE = "5개 일치 (1,500,000원) - %d개";
    private static final String OUTPUT_FOURTH_PLACE = "4개 일치 (50,000원) - %d개";
    private static final String OUTPUT_FIFTH_PLACE = "3개 일치 (5,000원) - %d개";
    private static final String OUTPUT_RETURN_RATE = "총 수익률은 %.1f%%입니다.";

    private LottoOutputView() {
    }

    public static void printWinningStatistics(List<Integer> winningCounts, float returnRate) {
        System.out.println(OUTPUT_WINNING_STATISTICS_BEFORE);
        System.out.printf(OUTPUT_FIRST_PLACE + lineSeparator, winningCounts.get(0));
        System.out.printf(OUTPUT_SECOND_PLACE + lineSeparator, winningCounts.get(1));
        System.out.printf(OUTPUT_THIRD_PLACE + lineSeparator, winningCounts.get(2));
        System.out.printf(OUTPUT_FOURTH_PLACE + lineSeparator, winningCounts.get(3));
        System.out.printf(OUTPUT_FIFTH_PLACE + lineSeparator, winningCounts.get(4));
        System.out.printf(OUTPUT_RETURN_RATE, returnRate);
    }

    public static void printPurchase(Integer money) {
        System.out.printf(PURCHASE_ANNOUNCEMENT + lineSeparator, money / LottoConstant.LOTTO_PRICE);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
}
