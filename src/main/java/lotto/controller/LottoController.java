package lotto.controller;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.validation.Validator;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Validator validator;
    private final LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView,
                           Validator validator, LottoService lottoService) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.validator = validator;
        this.lottoService = lottoService;
    }

    public void executeLottoPurchase() {
        while (true) {
            try {
                int purchaseAmount = purchaseAmount();
                resultView.displayLottos(lottoService.generateLottos(purchaseAmount));
                createWinningLotto().validateBonusNumber(validator);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int purchaseAmount() {
        return validator.validate(inputView.userInput());
    }

    private WinningLotto createWinningLotto() {
        return new WinningLotto(getWinningNumbers(), getBonusNumber());
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = inputView.lottoWinningNumbers();
        validator.winningNumbers(winningNumbers);
        return winningNumbers;
    }

    private int getBonusNumber() {
        return validator.parseInput(inputView.bonusNumber());
    }
}
