package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

  private final InputView inputView;
  private final OutputView outputView;
  private final LottoService lottoService;
  private final InputValidator inputValidator;
  public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, InputValidator inputValidator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lottoService = lottoService;
    this.inputValidator = inputValidator;
  }

  public void run() {

    String purchaseAmountInput = inputView.readPurchaseAmount();
    int validatedPurchaseAmount = InputValidator.validatePurchaseAmount(purchaseAmountInput);

    String winningNumbersInput = inputView.readWinningNumbers();
    List<Integer> validatedWinningNumbers = InputValidator.validateWinningNumbers(winningNumbersInput);

    String bonusNumberInput = inputView.readBonusNumber();
    int validatedBonusNumber = InputValidator.validateBonusNumber(bonusNumberInput, validatedWinningNumbers);
  }

}
