package lotto.model;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String DELIMITER = ",";

    private final Set<Integer> numbers;

    public WinningNumbers(String input) {
        List<Integer> parsedNumbers = parseNumbers(input);
        validate(parsedNumbers);
        this.numbers = new HashSet<>(parsedNumbers);
    }

    private List<Integer> parseNumbers(String input) {
        String[] tokens = input.split(DELIMITER);
        if (tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }

        List<Integer> parsedNumbers = new ArrayList<>();
        for (String token : tokens) {
            int number = parseNumber(token.trim());
            parsedNumbers.add(number);
        }
        return parsedNumbers;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validateNumberCount(numbers);
        LottoValidator.validateNumberRange(numbers);
        LottoValidator.validateNoDuplicates(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
