package lotto.util;

import java.util.Arrays;
import java.util.List;

public class LottoParser {

    public static List<Integer> parsingNumber(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> number.trim())
                .map(validNumber -> LottoValidator.validNumber(validNumber))
                .toList();
    }
}
