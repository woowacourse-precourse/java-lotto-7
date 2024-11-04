package lotto.util;

import lotto.exception.GeneralException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberParserWithComma {
    private static final String DELIMITER_COMMA = ",";

    private final NumberConverter numberConverter;

    public NumberParserWithComma(NumberConverter numberConverter) {
        this.numberConverter = numberConverter;
    }

    public Set<Integer> parseNumbers(String input) {
        Set<Integer> parsedNumbers = new HashSet<>();
        Arrays.stream(input.split(DELIMITER_COMMA))
                .map(this::parseNumber)
                .forEach(number -> {
                    if (!parsedNumbers.add(number)) {
                        throw new IllegalArgumentException(GeneralException.DUPLICATE_NUMBER);
                    }
                });
        return parsedNumbers;
    }

    private int parseNumber(String numberString) {
        return numberConverter.convertNumber(numberString);
    }
}
