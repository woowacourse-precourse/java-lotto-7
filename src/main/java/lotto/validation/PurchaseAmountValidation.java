package lotto.validation;

public class PurchaseAmountValidation {
  public void validatePurchaseAmount(long purchaseAmount){
    checkNegativeNumber(purchaseAmount);
    unitConfirmation(purchaseAmount);
  }
  void checkNegativeNumber(long purchaseAmount){
    if(purchaseAmount<0){
      throw new IllegalArgumentException("구입금액은 양수여야 합니다");

    }
  }
  void unitConfirmation(long purchaseAmount){
    if(purchaseAmount%1000!=0){
      throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다");
    }
  }
}
