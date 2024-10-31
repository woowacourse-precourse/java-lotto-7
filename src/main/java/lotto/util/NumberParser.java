package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumberParser {
    private static final String COMMA = ",";

    public static List<Integer> parseLottoNumbers(String input) {
        Stream<String> splitNumbers = Arrays.stream(input.split(COMMA));
        Stream<String> trimNumbers = splitNumbers.map(String::trim);
        //TODO: 숫자 아닌 입력 validation 추가 필요
        return trimNumbers.map(Integer::parseInt).toList();
    }

    public static int parseBonusNumber(String input) {
        String trimNumber = input.trim();
        //TODO: 숫자 아닌 입력 validation 추가 필요
        return Integer.parseInt(trimNumber);
    }
}
