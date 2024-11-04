package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parse(String lottoNums) {
        return Arrays.asList(lottoNums.split(","));
    }
}
