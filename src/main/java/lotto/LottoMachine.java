package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
