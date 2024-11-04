package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public static List<Integer> convertLottoNumber(String input) {
        List<Integer> numbers = Arrays.stream(input.split(Constants.DELIMITER))
                .map(String::trim)
                .peek(Validator::validateIsNumeric)
                .map(Integer::parseInt)
                .peek(Validator::validateLottoRange)
                .toList();

        Validator.validateNoDuplicates(numbers);
        Validator.validateLottoSize(numbers);

        return numbers;
    }
}
