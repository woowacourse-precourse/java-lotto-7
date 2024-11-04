package lotto.util;

import lotto.exception.GeneralExceptionMessages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberParserWithComma {

    private final NumberConverter numberConverter;

    public NumberParserWithComma(NumberConverter numberConverter) {
        this.numberConverter = numberConverter;
    }

    public Set<Integer> parseNumbers(String input) {
        Set<Integer> parsedNumbers = new HashSet<>();
        Arrays.stream(input.split(","))
                .map(this::parseNumber)
                .forEach(number -> {
                    if (!parsedNumbers.add(number)) {
                        throw new IllegalArgumentException(GeneralExceptionMessages.DUPLICATE_NUMBER);
                    }
                });
        return parsedNumbers;
    }

    private int parseNumber(String numberString) {
        return numberConverter.convertNumber(numberString);
    }
}
