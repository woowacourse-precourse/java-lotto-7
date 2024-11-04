package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoReward;
import lotto.domain.Lottos;
import lotto.domain.PurchasePrice;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_STATISTICS_MESSAGE = "\n당첨통계";
    private static final String LINE = "---";
    private static final String LOTTO_REWARD_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String LOTTO_SECOND_REWARD_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String LOTTO_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchasedLottos(Lottos lottos) {
        printLottoCount(lottos);
        printLottoNumbers(lottos);
    }

    private static void printLottoCount(Lottos lottos) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottos.lottoCount());
    }

    private static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .toList());
        }
    }

    public static void printLottoStatistics(LottoResult lottoResult, PurchasePrice purchasePrice) {
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        System.out.println(LINE);
        printLottoRewards(lottoResult);
        printLottoProfit(lottoResult.calculateProfit(purchasePrice));
    }

    private static void printLottoRewards(LottoResult lottoResult) {
        Map<LottoReward, Integer> lottoResults = lottoResult.getLottoResult();
        List<LottoReward> lottoRewards = Arrays.asList(LottoReward.values());

        for (LottoReward reward : lottoRewards) {
            printLottoReward(reward, lottoResults.get(reward));
        }
    }

    private static void printLottoReward(LottoReward lottoReward, int count) {
        if (lottoReward.equals(LottoReward.NONE)) {
            return;
        }
        if (lottoReward.equals(LottoReward.SECOND)) {
            System.out.printf(LOTTO_SECOND_REWARD_MESSAGE, count);
            return;
        }
        System.out.printf(LOTTO_REWARD_MESSAGE, lottoReward.getMatchCount(), lottoReward.getPrize(), count);
    }

    private static void printLottoProfit(double lottoProfit) {
        System.out.printf(LOTTO_PROFIT_MESSAGE, lottoProfit);
    }
}
