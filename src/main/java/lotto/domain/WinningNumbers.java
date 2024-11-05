package lotto.domain;

import java.util.List;
import lotto.utils.Converter;
import lotto.utils.WinningNumbersValidator;

public class WinningNumbers {
    private static final String DELIMITER = ",";
    private final List<Integer> winningNumbers;

    private WinningNumbers(String winningNumbers) {
        List<String> winningNumberStrings = splitInput(winningNumbers);
        WinningNumbersValidator.validateWinningNumbers(winningNumberStrings);
        this.winningNumbers = Converter.parseToIntegerList(winningNumberStrings);

    }

    public static WinningNumbers from(String winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    private List<String> splitInput(String input) {
        return List.of(input.split(DELIMITER));
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers);
    }
}
