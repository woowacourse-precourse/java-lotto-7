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

  public int purchaseAmountAndValidation(){
    int purchaseAmount=Integer.parseInt(inputMessageView.enterPurchaseAmount());
    purchaseAmountValidation.validatePurchaseAmount(purchaseAmount);
  }


}
