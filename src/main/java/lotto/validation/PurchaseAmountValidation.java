package lotto.validation;

public class PurchaseAmountValidation {
  public boolean validatePurchaseAmount(long purchaseAmount){
    try {
      checkNegativeNumber(purchaseAmount);
      unitConfirmation(purchaseAmount);
      return true;
    }catch (IllegalArgumentException e){
      System.out.println(e.getMessage());
      return false;
    }
  }
  void checkNegativeNumber(long purchaseAmount){
    if(purchaseAmount<0){
      throw new IllegalArgumentException("[ERROR] 구입금액은 양수여야 합니다");
    }
  }
  void unitConfirmation(long purchaseAmount){
    if(purchaseAmount%1000!=0){
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다");
    }
  }
}
