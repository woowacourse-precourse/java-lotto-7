package lotto.domain;

import lotto.ErrorCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WinningNumber {
    private static final Pattern isWinningNumberPattern = Pattern.compile("^(0?[1-9]|[1-3][0-9]|4[0-5])(,(0?[1-9]|[1-3][0-9]|4[0-5])){5}$");
    private static final String COMMA = ",";
    private final List<Integer> winningNumbers;

    public WinningNumber(String winningNumber) {
        validateWinningNumber(winningNumber);
        this.winningNumbers = parse(winningNumber);
    }

    private List<Integer> parse(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }

    private void validateWinningNumber(String winningNumber) throws IllegalArgumentException {
        validateWinningNumberRightFormat(winningNumber);
        validateWinningNumberDuplicate(winningNumber);
    }

    private void validateWinningNumberRightFormat(String input) {
        if (!isWinningNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage());
        }
    }

    private void validateWinningNumberDuplicate(String input) {
        List<Integer> numbers = parse(input);
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_DUPLICATE.getErrorMessage());
        }
    }
}