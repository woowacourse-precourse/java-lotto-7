package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private final String COMMA = ",";

    public List<Long> splitNumberByComma(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .filter(number -> !number.isBlank())
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
