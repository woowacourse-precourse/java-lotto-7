package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmount {


  private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

  private int purchaseQuantity;

  public PurchaseAmount(int purchaseAmount)
  {
    assignPurchaseQuantity(purchaseAmount);
  }

  private boolean validatePurchaseAmount(int purchaseAmount){
    if(purchaseAmount % 1000 == 0) return true;
    throw new IllegalArgumentException("[ERROR] 잘못된 가격");
  }

  public void assignPurchaseQuantity(int purchaseAmount){
    validatePurchaseAmount(purchaseAmount);
    this.purchaseQuantity = purchaseAmount / 1000 ;
  }

  public int getPurchaseQuantity()
  {
    return this.purchaseQuantity;
  }

}
