package lotto.service;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Results;
import lotto.view.OutputView;

public class OutputService {

    OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void showLotto(Lottos lottos) {
        outputView.showLottos(lottos);
    }

    public void showResults(Results results, Money money) {
        outputView.showResults(results, money);
    }
}
