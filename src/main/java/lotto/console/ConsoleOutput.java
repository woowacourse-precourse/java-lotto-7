package lotto.console;

import static lotto.common.Messages.BONUS_NUMBER_PROMPT;
import static lotto.common.Messages.LOTTO_COUNT_MESSAGE;
import static lotto.common.Messages.PURCHASE_AMOUNT_PROMPT;
import static lotto.common.Messages.RESULT_DIVIDER;
import static lotto.common.Messages.RESULT_TITLE;
import static lotto.common.Messages.TOTAL_PROFIT_RATE_FORMAT;
import static lotto.common.Messages.WINNING_NUMBER_PROMPT;
import static lotto.common.Messages.WINNING_STATISTICS_FORMAT;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.view.Output;

public class ConsoleOutput implements Output {

    @Override
    public void printPurchaseAmountPrompt() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }

    @Override
    public void printLottos(Lottos lottos) {
        System.out.println(LOTTO_COUNT_MESSAGE.formatted(lottos.size()));
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printWinningLottoPrompt() {
        System.out.println(WINNING_NUMBER_PROMPT);
    }

    @Override
    public void printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    @Override
    public void printResults(int[] results) {
        System.out.println(RESULT_TITLE);
        System.out.println(RESULT_DIVIDER);
        LottoRank[] ranks = LottoRank.values();
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] != LottoRank.NONE) {
                System.out.printf(WINNING_STATISTICS_FORMAT.formatted(
                        ranks[i].ordinal() + 3, ranks[i].getPrize(), results[i]));
            }
        }
    }

    @Override
    public void printEarningsRate(int totalPrize, int purchaseAmount) {
        double rate = (double) totalPrize / purchaseAmount * 100;
        System.out.printf(TOTAL_PROFIT_RATE_FORMAT.formatted(rate));
    }
}
