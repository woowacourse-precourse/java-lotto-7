package lotto.view.output;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStats;

import java.util.Arrays;
import java.util.List;

public class LottoOutputView {

    public void promptPurchaseAmount() {
        System.out.println(OutputMessage.MONEY_INPUT_MESSAGE.getMessage());
    }

    public void printLottoBundle(List<Lotto> lottoBundle) {
        System.out.println();
        System.out.println(OutputMessage.LOTTO_BUNDLE_MESSAGE.getMessage(lottoBundle.size()));
        lottoBundle.forEach(lotto -> System.out.println(lotto));
    }

    public void printLottoStats(LottoStats lottoStats) {
        System.out.println();
        System.out.println(OutputMessage.LOTTO_STATS_MESSAGE.getMessage());

        for (LottoPrize prize : Arrays.stream(LottoPrize.values()).toList().reversed()) {
            int count = lottoStats.getPrizeCountMap().getOrDefault(prize, 0);
            System.out.printf("%s - %d개\n", prize.getDescription(), count);
        }

        System.out.println(OutputMessage.LOTTO_PROFIT_RATE_MESSAGE.getMessage(lottoStats.getProfitRate()));
    }

    public void promptLottoDrawNumber() {
        System.out.println();
        System.out.println(OutputMessage.LOTTO_DRAW_INPUT_MESSAGE.getMessage());
    }

    public void promptBonusNumber() {
        System.out.println();
        System.out.println(OutputMessage.LOTTO_BONUS_DRAW_INPUT_MESSAGE.getMessage());
    }
}