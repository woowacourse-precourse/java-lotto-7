package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView output;
    private final InputView input;
    private final InputProcessor inputProcessor;
    private LottoManager lottoManager;
    private boolean flag;

    public LottoController() {
        this.input = new InputView();
        this.output = new OutputView();
        this.inputProcessor = new InputProcessor();
    }

    public boolean isFlag() {
        return flag;
    }

    public void run() {
        flag = false;
        output.printStartMessage();
        inputProcessor.processPrice(input.readLine());
        lottoManager = new LottoManager(inputProcessor.getTryCount());
        output.printTicket(inputProcessor.getTryCount(), lottoManager.getLottoTicket());
        output.printVictoryNumber();
        inputProcessor.processVictoryNumber(input.readLine());
        output.printBonusNumber();
        inputProcessor.processBonusNumber(input.readLine());
    }
}
