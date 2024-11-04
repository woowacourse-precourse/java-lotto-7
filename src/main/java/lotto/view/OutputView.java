package lotto.view;

import lotto.checker.domain.Lottos;
import lotto.purchase.domain.Money;
import lotto.results.domain.Result;
import lotto.results.domain.Results;

public interface OutputView {

    void showMoneyPrompt();

    void showLottos(Lottos lottos);

    void showWinningNumbersPrompt();

    void showBonusNumberPrompt();

    void showResults(Results results, Money money);

    String isSecond(Result result);

}
