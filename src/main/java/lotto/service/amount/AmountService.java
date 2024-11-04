package lotto.service.amount;

import lotto.model.amount.PurchaseAmount;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class AmountService {

  public int getPurchasableCount (PurchaseAmount amount, int price) {
    return amount.calculatePurchasableCount(price);
  }
}
