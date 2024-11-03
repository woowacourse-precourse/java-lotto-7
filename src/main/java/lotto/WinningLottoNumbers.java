package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String DELIMITER = ",";

    private final List<Integer> numbers;

    public WinningLottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static WinningLottoNumbers from(String input) {
        List<Integer> numbers = parseNumbers(input);
        return new WinningLottoNumbers(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isInvalidRange)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private boolean isInvalidRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
