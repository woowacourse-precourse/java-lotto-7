package lotto.io;

import java.util.Map;
import lotto.lotto.Lottos;

public interface OutputHandler {
    void showLottoPurchaseComments();

    void showExceptionMessage(IllegalArgumentException e);

    void showLottoCountComments(int lottoCount);

    void showLottoNumbersComments(Lottos lottos);

    void showWinningNumbersComments();

    void showBonusNumberComments();

    void showLottoStatistics(Map<String, Integer> rankCount);

    void showLottoTotalProfitRate(double profitRate);
}
