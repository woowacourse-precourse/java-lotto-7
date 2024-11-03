package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionCode.*;

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

    // todo: 함수 분리하기
    public Rank countRank(Lotto lotto, Integer bonus) {
        long count = this.numbers.stream().filter(lotto.numbers::contains).count();
        if (count == 6) {
            return Rank.FIRST;
        } else if (count == 5) {
            if (this.numbers.contains(bonus)) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        } else if (count == 4) {
            return Rank.FOURTH;
        } else if (count == 3) {
            return Rank.FIFTH;
        }
        return Rank.BLANK;
    }
}
