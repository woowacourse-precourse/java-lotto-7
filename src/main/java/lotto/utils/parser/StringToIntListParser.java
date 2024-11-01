package lotto.utils.parser;

import java.util.Arrays;
import java.util.List;

public class StringToIntListParser implements Parser<List<Integer>> {
    private String DELIMITER = ",";
    @Override
    public List<Integer> parse(String rawNumbers) {
        return Arrays.stream(rawNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
