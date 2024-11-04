package lotto.service;

import lotto.view.OutputMessageView;

public class OutputMessageService {
  private static Long LOTTO_PRICE=1000L;
  public Long numberOfPurchases(long purchaseAmount){
    return purchaseAmount/LOTTO_PRICE;
  }

}
