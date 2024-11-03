package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoParser {

    private static final int PRICE_UNIT = 1000;
    private static final String SEPARATOR = ",";
    private static final double PERCENTAGE = 100.0;
    private static final int DECIMAL_POINT = 10;

    public static List<Integer> parsingNumber(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(String::trim)
                .map(LottoValidator::validNumber)
                .toList();
    }

    public static int parsingPrice(int price) {
        return price / PRICE_UNIT;
    }

    public static double parsingRate(int totalPrize, int purchaseAmount) {
        return (double) Math.round((totalPrize * PERCENTAGE) / purchaseAmount * DECIMAL_POINT) / DECIMAL_POINT;
    }
}
