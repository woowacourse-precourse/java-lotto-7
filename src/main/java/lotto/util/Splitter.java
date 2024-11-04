package lotto.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Splitter {
    private final String COMMA = ",";

    public Set<Integer> splitNumberByComma(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .filter(number -> !number.isBlank())
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
