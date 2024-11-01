package lotto;

import lotto.view.OutputView;

public class LottoController {
    OutputView output = new OutputView();

    public LottoController() {
        this.output = new OutputView();
    }

    public void run() {
        output.printStartMessage();
    }
}
