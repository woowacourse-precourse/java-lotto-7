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
  public static final int PERCENTAGE_FOR_CALCULATION = 100;
  private static final Map<WinningType, Integer> prizeMap =
      Map.of(
          WinningType.FIFTH_PLACE, FIFTH_PLACE_PRICE,
          WinningType.FOURTH_PLACE, FOURTH_PLACE_PRICE,
          WinningType.THIRD_PLACE, THIRD_PLACE_PRICE,
          WinningType.SECOND_PLACE, SECOND_PLACE_PRICE,
          WinningType.FIRST_PLACE, FIRST_PLACE_PRICE);

  private final Integer totalPrice;

  private TotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  public static TotalPrice sumAllPrice(List<WinningType> winningStatistic) {
    Integer totalPrice =
        winningStatistic.stream()
            .mapToInt(winningType -> prizeMap.getOrDefault(winningType, 0))
            .sum();
    return new TotalPrice(totalPrice);
  }

  public double calculateReturnRate(Money money) {
    return Math.round((this.totalPrice % money.getMoney()) * PERCENTAGE_FOR_CALCULATION * 100) / 100.0;
  }

}
