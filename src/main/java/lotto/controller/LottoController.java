package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        LottoGame lottoGame = createNewLottoGame();
        outputView.renderGeneratedLottos(lottoGame);
    }

    private LottoGame createNewLottoGame() {
        return new LottoGame(getPurchaseAmount());
    }

    private Integer getPurchaseAmount() {
        try {
            return inputView.getPurchaseAmountInput();
        } catch (IllegalArgumentException e) {
            outputView.renderErrorMessage(e.getMessage());
            return getPurchaseAmount();
        }
    }
}
