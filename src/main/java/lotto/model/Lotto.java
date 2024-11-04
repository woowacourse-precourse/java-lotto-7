package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String LOTTO_DELIMITER = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto of(String rawNumbers) {
        String[] WinningNumberStrings = rawNumbers.split(LOTTO_DELIMITER);
        try {
            List<Integer> winningNumbers = Arrays.stream(WinningNumberStrings)
                    .map(Integer::parseInt)
                    .toList();
            return new Lotto(winningNumbers);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야합니다.");
        }
    }

    public boolean containsNumber(int numberToCheck) {
        return numbers.contains(numberToCheck);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersRange(numbers);
        validateNumberSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumberSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
