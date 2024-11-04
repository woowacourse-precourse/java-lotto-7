package lotto.utils.parser;

import static lotto.utils.constants.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;

public class StringToIntListParser implements Parser<List<Integer>> {

    @Override
    public List<Integer> parse(String rawNumbers) {
        return Arrays.stream(rawNumbers.split(DELIMITER.getDelimiter()))
                .map(Integer::parseInt)
                .toList();
    }
}
