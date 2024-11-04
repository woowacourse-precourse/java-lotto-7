package lotto.converter;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StringToIntegerSetConverter {

    public static Set<Integer> convertToTreeSet(String commaSeparatedNumbers) {
        if (commaSeparatedNumbers == null || commaSeparatedNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어 있습니다.");
        }

        return Arrays.stream(commaSeparatedNumbers.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(TreeSet::new));
    }
}
