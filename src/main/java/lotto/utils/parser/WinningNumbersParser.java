package lotto.utils.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class WinningNumbersParser {
    public static Lotto getWinningNumbers(String userWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(userWinningNumbers.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return new Lotto(winningNumbers);
    }
}
