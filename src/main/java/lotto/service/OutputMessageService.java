package lotto.service;

import java.util.Map;
import lotto.domain.LottoPrize;

public class OutputMessageService {
  private static Long LOTTO_PRICE=1000L;
  public Long numberOfPurchases(long purchaseAmount){
    return purchaseAmount/LOTTO_PRICE;
  }

  public double rateOfReturn(Map<LottoPrize, Integer> statistics, long purchaseAmount) {
    long totalPrize = 0;
    for (LottoPrize prize : LottoPrize.values()) {
      int count = statistics.getOrDefault(prize, 0);
      totalPrize += count * prize.getPrize();
    }
    double rateOfReturn = ((double) totalPrize / purchaseAmount) * 100;
    return rateOfReturn;
  }
}
