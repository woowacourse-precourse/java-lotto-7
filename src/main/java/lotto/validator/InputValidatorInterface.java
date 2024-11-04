package lotto.validator;

import java.util.List;

public interface InputValidatorInterface {

  int validatePurchaseAmount(String purchaseAmount);

  List<Integer> validateWinningNumbers(String winningNumbers);

  int validateBonusNumber(String bonusNumber, List<Integer> winningNumbers);
}
