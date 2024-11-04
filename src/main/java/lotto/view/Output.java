package lotto.view;

import lotto.domain.Lottos;

public interface Output {
    void printPurchaseAmountPrompt();

    void printLottos(Lottos lottos);

    void printWinningLottoPrompt();

    void printBonusNumberPrompt();

    void printResults(int[] results);

    void printEarningsRate(int totalPrize, int purchaseAmount);
}
