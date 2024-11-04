package lotto.Controller;

import lotto.Domain.LottoMachine;
import lotto.Domain.LottoNumber;
import lotto.View.InputView;
import lotto.View.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = new LottoMachine(inputView, outputView);
    }

    public void run() {
        inputView.requestLottoNumber();
        LottoNumber lottoNumber = lottoMachine.generateNumber();
        outputView.printLottoNumbers(lottoNumber.getNumbers());
    }
}
