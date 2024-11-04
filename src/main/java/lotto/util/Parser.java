package lotto.util;

import lotto.validate.Validator;

import java.util.Arrays;
import java.util.List;

public abstract class Parser {

    public static List<Integer> parseToList(String nums) {
        return Arrays.stream(Validator.validationDelimiter(nums))
                .map(Validator::validateParsingToInt)
                .map(Validator::validationInRange)
                .toList();
    }
    public static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
}
