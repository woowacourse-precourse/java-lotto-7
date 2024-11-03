package lotto.view;

import lotto.domain.lotto.dto.GetLottosDto;
import lotto.domain.lottoMachine.dto.GetResultDto;
import lotto.domain.money.dto.GetProfitRateDto;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(final InputView inputView, final OutputView outputView) {
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
        outputView.printNewLine();
        outputView.printMessage(Output.INPUT_BONUS_NUMBER);
        return inputView.userInput();
    }

    public void outputLottos(final GetLottosDto getLottosDto) {
        outputView.printLottos(getLottosDto);
    }

    public void outputResult(final GetResultDto getResultDto) {
        outputView.printNewLine();
        outputView.printMessage(Output.OUTPUT_STATISTICS);
        outputView.printMessage(Output.OUTPUT_DELIMITER);

        outputView.printResult(getResultDto);
    }

    public void outputProfitRate(final GetProfitRateDto getProfitRateDto) {
        outputView.printProfitRate(getProfitRateDto);
    }
}
