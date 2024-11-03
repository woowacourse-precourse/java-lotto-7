package lotto.utils.parser;

import java.util.Arrays;
import java.util.List;
import static lotto.utils.constants.Constants.DELIMITER;

public class StringToIntListParser implements Parser<List<Integer>> {

    @Override
    public List<Integer> parse(String rawNumbers) {
        return Arrays.stream(rawNumbers.split(DELIMITER.getDelimiter()))
                .map(Integer::parseInt)
                .toList();
    }
}
