package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoInputConvertor {

    private LottoInputConvertor() {
        
    }

    public static List<Integer> parseToNumbers(final String delimiter, final String input) {
        return Arrays.stream(input.split(delimiter))
                .map(LottoInputConvertor::parseToInt)
                .toList();
    }

    public static int parseToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
