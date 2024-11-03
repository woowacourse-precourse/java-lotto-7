package lotto.domain.number;

import lotto.global.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;

    private WinningNumbers(final String input) {
        this.winningNumbers = parseWinningNumbers(input);
        LottoValidator.validate(winningNumbers);
    }

    public static WinningNumbers from(final String input) {
        return new WinningNumbers(input);
    }

    private List<Integer> parseWinningNumbers(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int countMatchedNumbers(final List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(final int number) {
        return winningNumbers.contains(number);
    }
}