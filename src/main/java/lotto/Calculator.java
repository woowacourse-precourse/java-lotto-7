package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

  public enum WinningType {
    FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FORTH_PRIZE, FIFTH_PRIZE
  }

  private final Map<String, WinningType> winningConditions;

  public Calculator() {
    winningConditions = new HashMap<>();
    winningConditions.put("6,false", WinningType.FIRST_PRIZE);
    winningConditions.put("5,true", WinningType.SECOND_PRIZE);
    winningConditions.put("5,false", WinningType.THIRD_PRIZE);
    winningConditions.put("4,false", WinningType.FORTH_PRIZE);
    winningConditions.put("3,false", WinningType.FIFTH_PRIZE);
  }

  public WinningType calculateWinningSize(Lotto lotto, int[] winningNumbers, int bonusNumber) {
    int matchCount = lotto.countMatchingNumbers(winningNumbers);
    boolean bonusMatch = lotto.matchBonusNumber(bonusNumber);
    String key = matchCount + "," + bonusMatch;
    return winningConditions.getOrDefault(key, null); // 기본값 null 설정
  }

  public PrizeCounter calculatePrizes(List<Lotto> lottoPaper,
      LottoWinningNumbers lottoWinningNumbers) {
    PrizeCounter prizeCounter = new PrizeCounter();
    for (Lotto lotto : lottoPaper) {
      WinningType result = calculateWinningSize(lotto, lottoWinningNumbers.getWinningNumber(),
          lottoWinningNumbers.getBonusNumber());
      if (result != null) {
        prizeCounter.incrementPrizeCount(result);
      }
    }
    return prizeCounter;
  }

  public float CalculateProfit(PurchaseAmount purchaseAmount, PrizeCounter prizeCounter) {
    int totalPrizeMoney = 0;
    totalPrizeMoney +=
        prizeCounter.getPrizeCount().getOrDefault(Calculator.WinningType.FIRST_PRIZE, 0)
            * 2_000_000_000;
    totalPrizeMoney +=
        prizeCounter.getPrizeCount().getOrDefault(Calculator.WinningType.SECOND_PRIZE, 0)
            * 30_000_000;
    totalPrizeMoney +=
        prizeCounter.getPrizeCount().getOrDefault(Calculator.WinningType.THIRD_PRIZE, 0)
            * 1_500_000;
    totalPrizeMoney +=
        prizeCounter.getPrizeCount().getOrDefault(Calculator.WinningType.FORTH_PRIZE, 0) * 50_000;
    totalPrizeMoney +=
        prizeCounter.getPrizeCount().getOrDefault(Calculator.WinningType.FIFTH_PRIZE, 0) * 5_000;

    int totalSpent = purchaseAmount.getPurchaseQuantity() * 1000;
    return ((float) totalPrizeMoney / totalSpent) * 100;
  }

}
