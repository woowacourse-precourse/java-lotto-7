package lotto.view;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.LotteryBuyer;
import lotto.domain.PrizeTier;
import lotto.util.CommonUtil;

public class OutputView {

    public static void printLottery(LotteryBuyer lotteryBuyer) {
        System.out.println("\n" + lotteryBuyer.getLotteries().size() + "개를 구매했습니다.");
        lotteryBuyer.getLotteries().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningStatistics(Map<PrizeTier, Long> prizeCounts) {
        System.out.println("\n당첨 통계\n---");
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

        for (PrizeTier tier : PrizeTier.values()) {
            String prizeWithComma = numberFormat.format(tier.getPrize());
            System.out.printf("%d개 일치%s (%s원) - %d개\n",
                    tier.getMatchingCount(),
                    tier.isMatchBonus() ? ", 보너스 볼 일치" : "",
                    prizeWithComma,
                    prizeCounts.getOrDefault(tier, 0L));
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %s%%입니다.\n", CommonUtil.formatToSingleDecimalPlace(profitRate));
    }
}
