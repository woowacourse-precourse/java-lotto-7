package lotto.utils;

import java.util.Map;
import lotto.domain.WinningPrice;

public class ProfitCalculator {

    private static final String FORMAT_LENGTH = "%,.1f";

    private ProfitCalculator() {
    }

    public static String rate(Map<WinningPrice, Integer> winningPrice, int purchaseAmount) {
        double totalPrice = 0;
        for (WinningPrice price : winningPrice.keySet()) {
            totalPrice += (price.getPrice() * winningPrice.get(price));
        }
        double percentage = (totalPrice / purchaseAmount) * 100;
        percentage = Math.round(percentage * 100.0) / 100.0;

        return String.format(FORMAT_LENGTH, percentage);
    }

}
