package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.utils.ExceptionMessage;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        Predicate<Integer> isOutOfRange = number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
        if (numbers.stream().anyMatch(isOutOfRange)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto other){
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public static Lotto createWithRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }

    @Override
    public String toString() {
        String lottoInfo = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        return "[" + lottoInfo + "]";
    }

}
