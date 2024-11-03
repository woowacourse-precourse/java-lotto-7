package lotto.util.converter;

import java.util.Arrays;
import java.util.List;
import lotto.util.validator.NumberValidator;

public class StringToIntegerListConverter {
    private static final String DELIMITER = ",";
    public static List<Integer> convert(String source) {
        return convertListStringToListInteger(splitStringAsList(source));
    }

    private static List<String> splitStringAsList(String source) {
        return Arrays.asList(source.split(DELIMITER));
    }

    private static List<Integer> convertListStringToListInteger(List<String> source) {
        return source.stream()
                .peek(NumberValidator::validateInteger)
                .map(Integer::parseInt)
                .toList();
    }
}
