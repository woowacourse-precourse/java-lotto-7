package lotto.io;

import lotto.model.Lotto;

import java.util.List;

public interface LottoOutputHandler {

    void showPurchaseAmountPrompt();

    void showPurchasedLottos(List<Lotto> lottos);

    void showWinningNumbersPrompt();

    void showBonusNumberPrompt();

    void showPurchasedLottoCount(int count);

    void showProfitRate(double rate);

    void showErrorMessage(String errorMessage);
}
