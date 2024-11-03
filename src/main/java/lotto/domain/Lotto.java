package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String NOT_CORRECT_LOTTO_NUMBER_SIZE_MESSAGE = "6개의 수를 입력하셔야 합니다.";
    private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isSixNumbers(numbers);
        isDuplicatedNumber(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    private void isSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_LOTTO_NUMBER_SIZE_MESSAGE);
        }
    }

    private void isDuplicatedNumber(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if (hasDuplicates) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE);
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
