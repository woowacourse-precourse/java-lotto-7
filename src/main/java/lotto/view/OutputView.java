package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.WinningResult;

public interface OutputView {
    void printPurchasedLottoCount(int count);

    void printLottoTickets(Lottos lottos);

    void printResults(WinningResult winningResult);

    void printProfitRate(double profitRate);
}
