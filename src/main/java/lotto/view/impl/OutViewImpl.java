package lotto.view.impl;

import static lotto.constant.GameMessage.BONUS_LOTTO_MESSAGE;
import static lotto.constant.GameMessage.PRINT_BOUGHT_LOTTO_MESSAGE;
import static lotto.constant.GameMessage.PRINT_HOW_MANY_WINNING_MESSAGE;
import static lotto.constant.GameMessage.PRINT_PROFIT_RATE_MESSAGE;
import static lotto.constant.GameMessage.PRINT_WINNING_STATISTIC_MESSAGE;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.constant.WinningRank;
import lotto.model.Lotto;
import lotto.view.OutPutView;

public class OutViewImpl implements OutPutView {
    static NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    @Override
    public void printBoughtLotto(List<Lotto> boughtLotto) {
        PRINT_BOUGHT_LOTTO_MESSAGE.printGameMessage(boughtLotto.size());
        boughtLotto.forEach(lotto -> System.out.println(lotto.toString()));
    }

    @Override
    public void printWinningStatistic(Map<WinningRank, Integer> results) {
        PRINT_WINNING_STATISTIC_MESSAGE.printGameMessage();

        for (WinningRank rank : List.of(WinningRank.FIFTH, WinningRank.FOURTH, WinningRank.THIRD, WinningRank.SECOND,
                WinningRank.FIRST)) {
            String formattedPrize = numberFormat.format(rank.getPrize());
            String bonusMessage = "";

            if (rank.requiresBonus()) {
                bonusMessage = BONUS_LOTTO_MESSAGE.getMessage();
            }

            int count = results.getOrDefault(rank, 0);
            PRINT_HOW_MANY_WINNING_MESSAGE.printGameMessage(rank.getMatchCount(), bonusMessage, formattedPrize, count);
        }
    }

    @Override
    public void printProfitRate(double profitRate) {
        PRINT_PROFIT_RATE_MESSAGE.printGameMessage(profitRate);
    }
}
