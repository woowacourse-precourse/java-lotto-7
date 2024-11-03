package lotto.utils.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class WinningNumbersParser {
    public final static String COMMA_REGEX = ",";

    public static Lotto getWinningNumbers(String userWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(userWinningNumbers.split(COMMA_REGEX))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new Lotto(winningNumbers);
    }
}
