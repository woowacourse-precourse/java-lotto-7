package lotto;

import lotto.view.InputView;

public class LottoApplication {
    final InputView inputView;

    public LottoApplication(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputView.getBudget();
    }
}
