package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoParser {

    private static final int PRICE_UNIT = 1000;
    private static final String SEPARATOR = ",";

    public static List<Integer> parsingNumber(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(String::trim)
                .map(LottoValidator::validNumber)
                .toList();
    }

    public static int parsingPrice(int price) {
        return price / PRICE_UNIT;
    }
}
