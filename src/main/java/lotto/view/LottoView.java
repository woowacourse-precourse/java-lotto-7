package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;

import java.util.List;

public class LottoView {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoView() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public long requestLottoPurchaseAmount() {
        return inputHandler.inputLottoPurchaseMoney();
    }

    public LottoDto requestWinningNumbers() {
        return inputHandler.inputWinningNumbers();
    }

    public int requestBonusNumber() {
        return inputHandler.inputBonusNumber();
    }

    public void displayPurchaseInfo(LottosDto lottos) {
        outputHandler.outputPurchaseInfo(lottos);
    }

    public void displayResults(List<RankResultDto> winningResults) {
        outputHandler.outputResults(winningResults);
    }

    public void displayWinningStatistics(double profitRate) {
        outputHandler.outputWinningStatics(profitRate);
    }
}