package lotto.utils.parser;

import static lotto.constants.ErrorMessage.WINNING_NUMBER_IS_ONLY_INTEGER_ALLOWED;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class WinningNumbersParser {
    public final static String COMMA_REGEX = ",";

    public static Lotto getWinningNumbers(String userWinningNumbers) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(userWinningNumbers.split(COMMA_REGEX))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_ONLY_INTEGER_ALLOWED.getMessage());
        }
        return new Lotto(winningNumbers);
    }
}
