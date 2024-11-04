package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final Money LOTTO_PRICE = Money.from(1000L);
    private static final String NUMBER_SIZE_ERROR_MESSAGE = String.format("로또 번호는 %d개여야 합니다.", LOTTO_SIZE);
    private static final String NUMBER_RANGE_ERROR_MESSAGE =
            String.format("로또 번호는 %d이상 %d이하여야 합니다.", MIN_NUMBER, MAX_NUMBER);
    private static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "중복된 로또 번호가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInRange(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        List<Integer> nonDuplicatedNumber = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != nonDuplicatedNumber.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int countCommonElements(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
