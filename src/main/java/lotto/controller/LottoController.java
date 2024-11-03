package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.MyLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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

        MyLotto myLotto = createMyLotto();
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

    private MyLotto createMyLotto() {
        final List<Integer> winningNumbers = getWinningNumbers();
        return new MyLotto(winningNumbers, getBonusNumber(winningNumbers));
    }

    private List<Integer> getWinningNumbers() {
        try {
            return inputView.getWinningNumbersInput();
        } catch (IllegalArgumentException e) {
            outputView.renderErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private Integer getBonusNumber(final List<Integer> winningNumbers) {
        try {
            return inputView.getBonusNumberInput(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.renderErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
