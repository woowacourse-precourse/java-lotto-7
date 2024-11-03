package lotto.model;

import java.util.List;
import java.util.Map;
import lotto.enums.ErrorMessage;
import lotto.enums.WinningType;

public class TotalPrice implements ReturnRate {
    public static final int FIRST_PLACE_PRICE = 2000000000;
    public static final int SECOND_PLACE_PRICE = 30000000;
    public static final int THIRD_PLACE_PRICE = 1500000;
    public static final int FOURTH_PLACE_PRICE = 50000;
    public static final int FIFTH_PLACE_PRICE = 5000;

    private static final int DECIMAL_ROUNDING_PLACE = 100;
    private static final double PERCENTAGE_FOR_CALCULATION = 100.0;

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

    @Override
    public double calculateReturnRate(Money money) {
        try {
            return Math.round(
                (this.totalPrice / (double) money.getMoney())
                    * PERCENTAGE_FOR_CALCULATION
                    * DECIMAL_ROUNDING_PLACE)
            / (double) DECIMAL_ROUNDING_PLACE;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CALCULATE.getMessage());
        }
    }
}
