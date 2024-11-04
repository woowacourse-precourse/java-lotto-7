package lotto.view;

import java.util.Arrays;
import lotto.domain.LottoPrize;
import lotto.domain.LottoPrizeResult;
import lotto.domain.ProfitRate;

public class OutputLottoResultView {
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + "\n" + "---";
    private static final String OUTPUT_FIRST_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printResult(LottoPrizeResult lottoPrizeResult, ProfitRate profitRate) {
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(LottoPrize.values())
                .filter(prize -> !prize.equals(LottoPrize.EMPTY))
                .forEach(prize -> System.out.println(getPrintResultPrize(prize, lottoPrizeResult)));
        System.out.printf((OUTPUT_RATE_MESSAGE) + "\n", profitRate.getProfitRate());
    }

    private static String getPrintResultPrize(LottoPrize lottoPrize, LottoPrizeResult lottoPrizeResult) {
        if (lottoPrize == LottoPrize.SECOND) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE
                    , lottoPrize.getMatchCount()
                    , String.format("%,d", lottoPrize.getReward())
                    , lottoPrizeResult.getLottoPrizeCount(lottoPrize));
        }

        return String.format(OUTPUT_FIRST_RESULT_MESSAGE
                , lottoPrize.getMatchCount()
                , String.format("%,d", lottoPrize.getReward())
                , lottoPrizeResult.getLottoPrizeCount(lottoPrize));
    }
}
