package lotto.validation;

public class PurchaseAmountValidation {
  public boolean validatePurchaseAmount(String purchaseAmount){
    try {
      Long purchaseAmountLong=Long.parseLong(purchaseAmount);
      checkNegativeNumber(purchaseAmountLong);
      unitConfirmation(purchaseAmountLong);
      return true;
    }catch (NumberFormatException e) {
      System.out.println("[ERROR] 금액은 숫자를 입력해야 합니다.");
      return false;
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
