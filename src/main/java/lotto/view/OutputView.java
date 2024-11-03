package lotto.view;

import static lotto.constant.OutputMessage.EARNING_RATE_FORMAT;
import static lotto.constant.OutputMessage.LOTTO_COUNT_FORMAT;
import static lotto.constant.OutputMessage.LOTTO_FORMAT;
import static lotto.constant.OutputMessage.LOTTO_NUMBER_DELIMITER;
import static lotto.constant.OutputMessage.NEW_LINE;
import static lotto.constant.OutputMessage.PRIZE_FORMAT;
import static lotto.constant.OutputMessage.PRIZE_START_MESSAGE;

import lotto.constant.Prize;
import lotto.model.Lotto;
import lotto.model.LottoMatcher;
import lotto.model.LottoPurchaseMoney;
import lotto.model.Lottos;
import lotto.model.Money;

public class OutputView {

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
