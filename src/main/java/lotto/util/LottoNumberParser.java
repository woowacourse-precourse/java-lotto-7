package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {

    public static List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(LottoValidator::parseNumber)
                .collect(Collectors.toList());

        LottoValidator.validateWinningNumbers(numbers);
        return numbers;
    }
}
