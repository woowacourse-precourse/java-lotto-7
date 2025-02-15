package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseAmount {

  private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
  private int purchaseQuantity;

  public PurchaseAmount() {
    assignPurchaseQuantity(inputPurchaseAmount());
    System.out.println(this.toString());
  }

  public int inputPurchaseAmount() {
    System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    int purchaseAmount = Integer.parseInt(Console.readLine());
    System.out.println();
    return purchaseAmount;
  }

  private boolean validatePurchaseAmount(int purchaseAmount) {
    if (purchaseAmount % 1000 == 0) {
      return true;
    }
    throw new IllegalArgumentException("잘못된 금액입니다.");
  }

  public void assignPurchaseQuantity(int purchaseAmount) {
    try {
      validatePurchaseAmount(purchaseAmount);
    } catch (IllegalArgumentException e) {
      System.out.print("[ERROR] ");
      System.out.println(e.getMessage());
      assignPurchaseQuantity(inputPurchaseAmount());
    }
    this.purchaseQuantity = purchaseAmount / 1000;
  }

  public int getPurchaseQuantity() {
    return this.purchaseQuantity;
  }

  public String toString() {
    return purchaseQuantity + PURCHASE_MESSAGE;
  }

}
