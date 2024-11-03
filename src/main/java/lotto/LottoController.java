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

    public LottoController() {
        this.input = new InputView();
        this.output = new OutputView();
        this.inputProcessor = new InputProcessor();
    }

    public void run() {
        output.printStartMessage();
        TryCountDTO tryCountDTO = inputCount();
        lottoManager = new LottoManager(tryCountDTO);
        output.printTicket(inputProcessor.getTryCount(), lottoManager.getLottoTicket());
        output.printVictoryNumber();
        readVictoryNumber();
        output.printBonusNumber();
        readBonusNumber();
        VictoryInfoDTO victoryInfoDTO = inputVictoryNumber();
        output.printResult(lottoManager.match(victoryInfoDTO));
        output.printRevenue(lottoManager.revenue(tryCountDTO));
    }

    private VictoryInfoDTO inputVictoryNumber() {
        return new VictoryInfoDTO(inputProcessor.getVictoryNumbers(), inputProcessor.getBonusNumber());
    }

    private void readBonusNumber() {
        while (true) {
            try {
                inputProcessor.processBonusNumber(input.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readVictoryNumber() {
        while (true) {
            try {
                inputProcessor.processVictoryNumber(input.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private TryCountDTO inputCount() {
        while (true) {
            try {
                inputProcessor.processPrice(input.readLine());
                return new TryCountDTO(inputProcessor.getTryCount(), inputProcessor.getBuyPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
