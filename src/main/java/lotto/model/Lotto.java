package lotto.model;

import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    public List<Integer> getAllNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(final List<Integer> numbers) {
        checkCountOfLottoNumbers(numbers.size());
        checkMinimumOfLottoNumber(numbers);
        checkMaximumOfLottoNumber(numbers);
        checkDuplicatedNumbers(numbers);
    }

    private void checkCountOfLottoNumbers(final int size) {
        if (size != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkMinimumOfLottoNumber(final List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < MIN_LOTTO_NUMBER)
                .findAny()
                .ifPresent(invalidNumber -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상의 숫자여야 합니다.");
                });
    }

    private void checkMaximumOfLottoNumber(final List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > MAX_LOTTO_NUMBER)
                .findAny()
                .ifPresent(invalidNumber -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.");
                });
    }

    private void checkDuplicatedNumbers(final List<Integer> numbers) {
        final long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 존재합니다.");
        }
    }

    private List<Integer> sortAscending(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
