package lotto.service;

import lotto.view.OutputMessageView;

public class OutputMessageService {
  public Long numberOfPurchases(long purchaseAmount){
    return purchaseAmount/1000;
  }

}
