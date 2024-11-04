package lotto.view.output;

import lotto.domain.Prize;
import lotto.domain.PrizeResult;

public class PrizeOutputView {

    private static final String HEADER_MESSAGE = "당첨 통계\n---";
    private static final String SECOND_PRIZE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String STANDARD_PRIZE_MESSAGE = "%d개 일치 (%,d원) - %d개\n";

    public static void showPrizeResults(PrizeResult prizeResult) {
        System.out.println(HEADER_MESSAGE);
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                continue;
            }
            printPrizeResult(prize, prizeResult.getPrizeCount().get(prize));
        }
    }

    private static void printPrizeResult(Prize prize, int count) {
        if (prize == Prize.SECOND) {
            printSecondPrize(prize, count);
            return;
        }
        printStandardPrize(prize, count);
    }

    private static void printSecondPrize(Prize prize, int count) {
        System.out.printf(SECOND_PRIZE_MESSAGE,
                prize.getCount(),
                prize.getPrize(),
                count);
    }

    private static void printStandardPrize(Prize prize, int count) {
        System.out.printf(STANDARD_PRIZE_MESSAGE,
                prize.getCount(),
                prize.getPrize(),
                count);
    }
}
