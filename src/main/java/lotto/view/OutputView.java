package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;

public interface OutputView {
    void printPurchaseAmount(int count);
    void printLottos(List<Lotto> lottos);
    void printResult(LottoResult result);
    void printProfit(double profit);
    void printError(String message);
}
