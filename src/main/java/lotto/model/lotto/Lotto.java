package lotto.model.lotto;

import lotto.model.generator.NumberGenerator;
import lotto.model.match.Match;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Error.LOTTO_LENGTH_LIMIT;
import static lotto.common.Error.NOT_DUPLICATED_NUMBER;
import static lotto.common.Error.OUT_OF_RANGE;
import static lotto.common.Rule.NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        validateRange(numbers);
        validateLength(numbers);
        validateDuplication(numbers);
        return new Lotto(numbers);
    }

    public static Lotto from(NumberGenerator numberGenerator) {
        List<Integer> generatedNumbers = numberGenerator.generate();
        List<Integer> sortedGeneratedNumbers = generatedNumbers.stream().sorted().toList();
        return new Lotto(sortedGeneratedNumbers);
    }

    public Match compareTo(Lotto lotto, Bonus bonus) {
        long equalCount = numbers.stream().filter(lotto::isContain).count();
        boolean isMatchBonus = isContain(bonus.number());
        return Match.of((int) equalCount, isMatchBonus);
    }

    public boolean isAllMatch(Lotto lotto) {
        long equalCount = numbers.stream().filter(lotto::isContain).count();
        return equalCount == numbers.size();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isOutOfRange =
                numbers.stream().anyMatch(number -> number < 1 || number > 45);
        if (isOutOfRange) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(LOTTO_LENGTH_LIMIT.getMessage());
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        boolean isDuplicated = new HashSet<>(numbers).size() != numbers.size();
        if (isDuplicated) {
            throw new IllegalArgumentException(NOT_DUPLICATED_NUMBER.getMessage());
        }
    }

    @Override
    public int hashCode() {
        return numbers.stream().mapToInt(number -> 31 * Integer.hashCode(number)).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) obj;
        return this.isAllMatch(lotto);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(number -> Integer.toString(number))
                .collect(Collectors.joining(", ")) + "]";
    }
}
