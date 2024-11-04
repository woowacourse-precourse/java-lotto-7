package lotto.domain;

import lotto.common.ErrorMessage;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDistinctNumber(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validateDistinctNumber(List<Integer> numbers) {
        long totalSize = numbers.stream().distinct().count();
        if (numbers.size() != totalSize) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public int findHits(List<Integer> winningNumbers) {
        long hits = numbers.stream().filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number)))
                .count();

        return (int) hits;
    }

    public BonusExistence findBonus(int hits, int bonusNumber) {
        boolean haveBonus = numbers.stream().anyMatch(number -> number == bonusNumber);

        return BonusExistence.of(hits, haveBonus);
    }
}
