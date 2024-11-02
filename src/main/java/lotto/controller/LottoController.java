package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.service.LottosServiceInterface;
import lotto.validator.InputValidator;
import lotto.validator.InputValidatorInterface;
import lotto.view.InputView;
import lotto.view.InputViewInterface;
import lotto.view.OutputView;
import lotto.view.OutputViewInterface;

public class LottoController {

  private final InputViewInterface inputView;
  private final OutputViewInterface outputView;
  private final LottosServiceInterface lottoService;
  private final InputValidatorInterface inputValidator;

  public LottoController(InputViewInterface inputView, OutputViewInterface outputView,
      LottosServiceInterface lottoService, InputValidatorInterface inputValidator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lottoService = lottoService;
    this.inputValidator = inputValidator;
  }

  public void run() {

    String purchaseAmountInput = inputView.readPurchaseAmount();
    int validatedPurchaseAmount = inputValidator.validatePurchaseAmount(purchaseAmountInput);

    String winningNumbersInput = inputView.readWinningNumbers();
    List<Integer> validatedWinningNumbers = inputValidator.validateWinningNumbers(
        winningNumbersInput);

    String bonusNumberInput = inputView.readBonusNumber();
    int validatedBonusNumber = inputValidator.validateBonusNumber(bonusNumberInput,
        validatedWinningNumbers);
  }

}
