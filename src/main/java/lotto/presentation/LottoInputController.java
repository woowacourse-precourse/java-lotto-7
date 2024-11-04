package lotto.presentation;

import lotto.util.Parser;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

import java.util.List;

public class LottoInputController {

  public int getValidatedPurchaseAmount() {
    String purchaseAmountInput = InputView.getPurchaseAmount();
    int purchaseAmount = Parser.parseInt(purchaseAmountInput);
    LottoValidator.validatePurchaseAmount(purchaseAmount);
    return purchaseAmount;
  }

  public List<Integer> getValidatedWinningNumbers() {
    String winningNumbersInput = InputView.getWinningNumbers();
    List<Integer> winningNumbers = Parser.parseWinningNumbers(winningNumbersInput);
    LottoValidator.validateLottoNumbers(winningNumbers);
    return winningNumbers;
  }

  public int getValidatedBonusNumber(List<Integer> winningNumbers) {
    String bonusNumberInput = InputView.getBonusNumber();
    int bonusNumber = Parser.parseInt(bonusNumberInput);
    BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);
    return bonusNumber;
  }
}
