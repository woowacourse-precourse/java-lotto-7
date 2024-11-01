package lotto.model;

import java.util.List;
import java.util.Map;
import lotto.enums.WinningType;

public class TotalPrice {
  public static final int FIRST_PLACE_PRICE = 2000000000;
  public static final int SECOND_PLACE_PRICE = 30000000;
  public static final int THIRD_PLACE_PRICE = 1500000;
  public static final int FOURTH_PLACE_PRICE = 50000;
  public static final int FIFTH_PLACE_PRICE = 5000;

  private static final Map<WinningType, Integer> prizeMap =
      Map.of(
          WinningType.FIFTH_PLACE, FIFTH_PLACE_PRICE,
          WinningType.FOURTH_PLACE, FOURTH_PLACE_PRICE,
          WinningType.THIRD_PLACE, THIRD_PLACE_PRICE,
          WinningType.SECOND_PLACE, SECOND_PLACE_PRICE,
          WinningType.FIRST_PLACE, FIRST_PLACE_PRICE);
          
  private final List<WinningType> winningStatistic;

  public TotalPrice(List<WinningType> winningStatistic) {
    this.winningStatistic = winningStatistic;
  }

  public int sumAllPrice() {
    return winningStatistic.stream()
        .mapToInt(winningType -> prizeMap.getOrDefault(winningType, 0))
        .sum();
  }
}
