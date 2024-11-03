package lotto.Domain;

import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoMachine {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoNumber generateNumber() {
        return new LottoNumber();
    }
}

