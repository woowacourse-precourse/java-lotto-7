package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.EnterWinningNumberValidation;
import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputMessageView;

public class InputMessageService {

  private final InputMessageView inputMessageView;
  private final PurchaseAmountValidation purchaseAmountValidation;
  private final EnterWinningNumberValidation enterWinningNumberValidation;

  public InputMessageService(InputMessageView inputMessageView,
      PurchaseAmountValidation purchaseAmountValidation,
      EnterWinningNumberValidation enterWinningNumberValidation) {
    this.inputMessageView = inputMessageView;
    this.purchaseAmountValidation = purchaseAmountValidation;
    this.enterWinningNumberValidation = enterWinningNumberValidation;
  }

  public Long enterPurchaseAmountAndValidation() {
    long purchaseAmount = 0;
    boolean isValid = false;
    while (!isValid) {
      purchaseAmount = Long.parseLong(inputMessageView.enterPurchaseAmount());
      isValid = purchaseAmountValidation.validatePurchaseAmount(purchaseAmount);

    }
    return purchaseAmount;
  }


  public Lotto enterWinningNumberAndValidation() {
    boolean isValid = false;
    while (!isValid) {
      List<Integer> enterNumbers = new ArrayList<>();
      String[] splitResult = inputMessageView.enterWinningNumber().split(",");
      for (int i = 0; i < splitResult.length; i++) {
        enterNumbers.add(Integer.parseInt(splitResult[i]));
      }
      isValid = enterWinningNumberValidation.validateEnterWinningNumber(enterNumbers);
    }
    return null;
  }
}
