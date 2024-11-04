package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
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
        getResult(createNewLottoGame(), createMyLotto());
    }

    private LottoGame createNewLottoGame() {
        LottoGame lottoGame = new LottoGame(getPurchaseAmount());
        outputView.renderGeneratedLottos(lottoGame);
        return lottoGame;
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
        final Lotto winningNumbers = getWinningNumbers();
        return new MyLotto(winningNumbers, getBonusNumber(winningNumbers.getNumbers()));
    }

    private Lotto getWinningNumbers() {
        try {
            return new Lotto(inputView.getWinningNumbersInput());
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

    private void getResult(final LottoGame lottoGame, final MyLotto myLotto) {
        final LottoResult lottoResult = new LottoResult(lottoGame.getPurchaseAmount());
        lottoGame.getGeneratedLottos().forEach(lotto -> lottoResult.checkLottoRank(lotto, myLotto));
        outputView.renderResult(lottoResult.getLottoRankBoard(), lottoResult.calcRateOfReturn());
    }
}
