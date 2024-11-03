package lotto.service;

import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputMessageView;

public class InputMessageService {

  private final InputMessageView inputMessageView;
  private final PurchaseAmountValidation purchaseAmountValidation;
  public InputMessageService(InputMessageView inputMessageView, PurchaseAmountValidation purchaseAmountValidation) {
    this.inputMessageView=inputMessageView;
    this.purchaseAmountValidation=purchaseAmountValidation;
  }

  public Long purchaseAmountAndValidation(){
    long purchaseAmount = 0;
    boolean isValid = false;
    while(!isValid) {
        purchaseAmount=Long.parseLong(inputMessageView.enterPurchaseAmount());
        isValid= purchaseAmountValidation.validatePurchaseAmount(purchaseAmount);

    }
    return purchaseAmount;
  }


}
