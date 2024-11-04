package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String DELIMITER = ",";

    private final Set<Integer> numbers;

    public WinningNumbers(String input) {
        List<Integer> parsedNumbers = parseNumbers(input);
        validateNumbers(parsedNumbers);
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

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
