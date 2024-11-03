package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;

public interface OutputView {

    void printPurchaseGuide();

    void printPurchasedAmount(int count);

    void printLottoTicket(List<Lotto> lottoBundle);

    void printWinningNumbersGuide();

    void printBonusNumberGuide();

    void printWinningStatistics();

    void printWinningResult(Map<Rank, Integer> rankCount);

    void printProfitRate(double rate);

    void printErrorMessage(String message);

    void printNewLine();
}
