package lotto.factory;

import lotto.model.WinningStatistic;

public class WinningStatisticFactory {
    public static WinningStatistic createWinningStatistic() {
        return new WinningStatistic();
    }

    public static WinningStatistic createWinningStatisticWithProfitRate(WinningStatistic existingInstance,
                                                                        double profitRate) {
        return existingInstance.createWithProfitRate(existingInstance, profitRate);
    }
}
