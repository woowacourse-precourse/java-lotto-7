package lotto.domain;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ExceptionCode.DUPLICATED_NUMBER;
import static lotto.exception.ExceptionCode.INCORRECT_NUMBER_COUNTS;

public class Lotto {
    private final List<Integer> numbers;
    public static final int NUMBER_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_COUNTS.message());
        }

        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.message());
        }
    }

    public Rank countRank(Lotto lotto, Integer bonus) {
        long count = this.numbers.stream().filter(lotto.numbers::contains).count();
        boolean containsBonus = this.numbers.contains(bonus);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches(count, containsBonus))
                .findFirst().orElse(Rank.BLANK);
    }
}
