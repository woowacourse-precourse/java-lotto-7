package Util;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Parser {
    public static final String INPUT_DELIMITER = ",";

    public List<Integer> parseLottoNumbers(String inputValue) {
        List<String> NumberStringList = Arrays.asList(inputValue.split(INPUT_DELIMITER));

        List<Integer> NumberList = NumberStringList.stream()
                                                   .map(Integer::parseInt)
                                                   .collect(Collectors.toList());
        return NumberList;
    }
}
