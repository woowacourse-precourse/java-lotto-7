package lotto;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningNumber {
    private final TreeSet<Integer> winningNumbers;

    public WinningNumber(String inputWinningNumbers){
        winningNumbers = validateAndCollectWinningNumbers(inputWinningNumbers);
    }

    private TreeSet<Integer> validateAndCollectWinningNumbers(String inputWinningNumbers){
        TreeSet<Integer> numbers = Arrays.asList(inputWinningNumbers.split(",")).stream()
                .map(WinnerNumberValidator::isNotEmpty)
                .map(WinnerNumberValidator::canParseToInt)
                .map(WinnerNumberValidator::isInRange)
                .collect(Collectors.toCollection(TreeSet::new));
        WinnerNumberValidator.isSixDifferentNumbers(numbers);
        return numbers;
    }
}
