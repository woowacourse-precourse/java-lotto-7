package lotto;

import lotto.DTO.TryCountDTO;
import lotto.DTO.VictoryInfoDTO;
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
        TryCountDTO tryCountDTO = inputCount();
        lottoManager = new LottoManager(tryCountDTO);
        output.printTicket(inputProcessor.getTryCount(), lottoManager.getLottoTicket());
        output.printVictoryNumber();
        inputProcessor.processVictoryNumber(input.readLine());
        output.printBonusNumber();
        inputProcessor.processBonusNumber(input.readLine());
        VictoryInfoDTO victoryInfoDTO = inputVictoryNumber();
        output.printResult(lottoManager.match(victoryInfoDTO));
        output.printRevenue(lottoManager.revenue(tryCountDTO));
    }

    private VictoryInfoDTO inputVictoryNumber() {
        return new VictoryInfoDTO(inputProcessor.getVictoryNumbers(), inputProcessor.getBonusNumber());
    }

    private TryCountDTO inputCount() {
        inputProcessor.processPrice(input.readLine());
        return new TryCountDTO(inputProcessor.getTryCount(), inputProcessor.getBuyPrice());
    }
}
