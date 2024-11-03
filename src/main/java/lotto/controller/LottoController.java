package lotto.controller;

import lotto.domain.Lotto;
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
                int bonusNumber = bonusNumber(winningNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int purchaseAmount() {
        return validator.validate(inputView.userInput());
    }

    private List<Integer> winningNumbers() {
        List<Integer> winningNumbers = inputView.lottoWinningNumbers();
        validator.winningNumbers(winningNumbers);
        return winningNumbers;
    }

    private int bonusNumber(List<Integer> winningNumbers) {
        String bonusNumberInput = inputView.bonusNumber();
        int bonusNumber = validator.parseInput(bonusNumberInput);
        validator.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

}
