package lotto.shared.application;

import lotto.checker.domain.Lottos;
import lotto.purchase.domain.Money;
import lotto.results.domain.Results;
import lotto.view.OutputView;

public class OutputService {

    private final OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void showMoneyPrompt() {
        outputView.showMoneyPrompt();
    }

    public void showLotto(Lottos lottos) {
        outputView.showLottos(lottos);
    }

    public void showWinningNumbersPrompt() {
        outputView.showWinningNumbersPrompt();
    }

    public void showBonusNumberPrompt() {
        outputView.showBonusNumberPrompt();
    }

    public void showResults(Results results, Money money) {
        outputView.showResults(results, money);
    }
}
