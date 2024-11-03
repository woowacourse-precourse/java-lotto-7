package lotto.view;

import lotto.domain.lotto.dto.GetLottosDto;
import lotto.domain.lottoMachine.dto.GetResultDto;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String inputMoney() {
        outputView.printMessage(Output.INPUT_MONEY);
        return inputView.userInput();
    }

    public String inputWinningLotto() {
        outputView.printMessage(Output.INPUT_WINNING_NUMBER);
        return inputView.userInput();
    }

    public String inputBonusNumber() {
        System.out.print(Output.NEW_LINE.message);
        outputView.printMessage(Output.INPUT_BONUS_NUMBER);
        return inputView.userInput();
    }

    public void outputLottos(GetLottosDto getLottosDto) {
        outputView.printLottos(getLottosDto);
    }

    public void outputResult(GetResultDto getResultDto) {
        System.out.print(Output.NEW_LINE.message);
        outputView.printMessage(Output.OUTPUT_STATISTICS);
        outputView.printMessage(Output.OUTPUT_DELIMITER);

        outputView.printResult(getResultDto);
    }
}
