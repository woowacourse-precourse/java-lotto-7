package lotto.domain;

import static lotto.util.ErrorResponse.INVALID_LOTTO_COUNT;
import static lotto.util.ErrorResponse.INVALID_LOTTO_NUMBER;
import static lotto.util.ErrorResponse.INVALID_LOTTO_NUM_DUPLICATE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.type.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUM_DUPLICATE.getMessage());
        }
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoRank match(Lotto target, int bonusNumber) {
        long count = numbers.stream()
                .filter(target.numbers::contains)
                .count();

        boolean isMatchBonus = numbers.contains(bonusNumber);

        return LottoRank.valueOf(count, isMatchBonus);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
