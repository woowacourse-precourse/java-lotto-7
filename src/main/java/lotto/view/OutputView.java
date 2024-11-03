package lotto.view;

import lotto.constant.Prize;
import lotto.model.Lotto;
import lotto.model.LottoMatcher;
import lotto.model.LottoPurchaseMoney;
import lotto.model.Lottos;
import lotto.model.Money;

public class OutputView {
    private static final String NEW_LINE = "%n";
    private static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.%n";
    private static final String LOTTO_FORMAT = "[%s]%n";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String PRIZE_START_MESSAGE = "당첨 통계%n---%n";
    private static final String PRIZE_FORMAT = "%s - %s개%n";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.%n";

    private OutputView() {
    }

    public static void println(String message) {
        System.out.print(message);
        System.out.printf(NEW_LINE);
    }

    public static void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_COUNT_FORMAT, lottos.count());
        for (Lotto lotto : lottos.toList()) {
            System.out.printf(
                    LOTTO_FORMAT,
                    String.join(LOTTO_NUMBER_DELIMITER, lotto.toSortedStrings())
            );
        }
    }

    public static void printPrizeStats(LottoMatcher lottoMatcher, LottoPurchaseMoney invested) {
        System.out.printf(PRIZE_START_MESSAGE);

        for (Prize prize : Prize.prizesOrderedBy(Prize.earningAscending())) {
            System.out.printf(
                    PRIZE_FORMAT,
                    prize.getDescription(),
                    lottoMatcher.getPrizeCount(prize)
            );
        }

        Money totalEarning = lottoMatcher.getTotalEarning();
        System.out.printf(EARNING_RATE_FORMAT, invested.getEarningRate(totalEarning));
    }
}
