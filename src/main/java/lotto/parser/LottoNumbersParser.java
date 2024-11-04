package lotto.parser;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersParser {
    public static List<Integer> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
