package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView output;
    private final InputView input;
    private final InputProcessor inputProcessor;
    private LottoManager lottoManager;

    public LottoController() {
        this.input = new InputView();
        this.output = new OutputView();
        this.inputProcessor = new InputProcessor();
    }

    public void run() {
        output.printStartMessage();
        inputProcessor.processPrice(input.readLine());
        lottoManager = new LottoManager(inputProcessor.getTryCount());
        output.printTicket(lottoManager.getLottoTicket());
    }
}
