package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.util.ResultMessage;

public class ResultView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(ResultMessage.LOTTO_COUNT.getMessage(), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printPrize(List<LottoPrize> prizes) {
        System.out.println(ResultMessage.WINNING_STAT.getMessage());
        List<LottoPrize> reversedPrizes = Arrays.asList(LottoPrize.values());
        Collections.reverse(reversedPrizes);

        for (LottoPrize prize : reversedPrizes) {
            if (prize == LottoPrize.SECOND) {
                System.out.printf(ResultMessage.LOTTO_BONUS_STATISTICS_FORMAT.getMessage(), prize.getMatchCount(),
                        prize.getPrize(), prizes.stream().filter(prize::equals).count());
            } else if (prize != LottoPrize.NONE) {
                System.out.printf(ResultMessage.LOTTO_STATISTICS_FORMAT.getMessage(), prize.getMatchCount(),
                        prize.getPrize(), prizes.stream().filter(prize::equals).count());
            }
        }
    }

    public static void printProfit(double profit) {
        System.out.printf(ResultMessage.LOTTO_PROFIT_MESSAGE.getMessage(), profit);
    }
}
