package lotto.utils;

import static lotto.utils.Validator.EMPTY_STRING;
import static lotto.utils.Validator.WHITESPACE_PATTERN;
import static lotto.utils.Validator.checkDuplicates;
import static lotto.view.OutputView.LOTTO_NUMBER_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static int priceToLottoCount(String input) {
        int count = Integer.parseInt(input);
        return count / 1000;
    }

    public static int StringToPrice(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> StringToLottoNumbers(String input) {
        input = input.replaceAll(WHITESPACE_PATTERN, EMPTY_STRING);

        List<Integer> numbers = Arrays.stream(input.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        checkDuplicates(numbers);

        return numbers;
    }

    public static int StringToBonusNumber(String input) {
        return Integer.parseInt(input);
    }
}
