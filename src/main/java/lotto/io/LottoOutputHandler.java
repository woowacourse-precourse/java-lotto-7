package lotto.io;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public interface LottoOutputHandler {

    void showPurchaseAmountPrompt();

    void showPurchasedLottos(List<Lotto> lottos);

    void showWinningNumbersPrompt();

    void showBonusNumberPrompt();

    void showResults(LottoResult result);

    void showPurchasedLottoCount(int count);

    void showProfitRate(double rate);

    void showErrorMessage(String errorMessage);
}
