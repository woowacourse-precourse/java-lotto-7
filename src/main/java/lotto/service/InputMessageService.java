package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.PurchaseAmountValidation;
import lotto.view.InputMessageView;

public class InputMessageService {

  private final InputMessageView inputMessageView;
  private final PurchaseAmountValidation purchaseAmountValidation;
  public InputMessageService(InputMessageView inputMessageView, PurchaseAmountValidation purchaseAmountValidation) {
    this.inputMessageView=inputMessageView;
    this.purchaseAmountValidation=purchaseAmountValidation;
  }

  public Long enterPurchaseAmountAndValidation(){
    long purchaseAmount = 0;
    boolean isValid = false;
    while(!isValid) {
        purchaseAmount=Long.parseLong(inputMessageView.enterPurchaseAmount());
        isValid= purchaseAmountValidation.validatePurchaseAmount(purchaseAmount);

    }
    return purchaseAmount;
  }


  public Lotto enterWinningNumberAndValidation() {
    List<Integer> enterNumbers=new ArrayList<>();
    String[] splitREsult=inputMessageView.enterWinningNumber().split(",");
    for(int i=0;i<splitREsult.length;i++){
      enterNumbers.add(Integer.parseInt(splitREsult[i]));
    }
    return new Lotto(enterNumbers);
  }
}
