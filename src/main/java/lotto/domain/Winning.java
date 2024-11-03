package lotto.domain;

import static lotto.constant.Error.DUPLICATED_WINNING_BONUS_NUMBERS;
import static lotto.constant.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.Error.SIZE_WINNING_NUMBERS;
import static lotto.constant.LottoConstant.SIZE_NUMBERS;

import java.util.List;

public class Winning {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(Lotto lotto) {
        int hitCount = (int) numbers
            .stream()
            .filter(lotto::hasNumber)
            .count();
        boolean hitsBonusNumber = lotto.hasNumber(bonusNumber);

        return Rank.of(hitCount, hitsBonusNumber);
    }

    private static void validate(List<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_BONUS_NUMBERS);
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != SIZE_NUMBERS) {
            throw new IllegalArgumentException(SIZE_WINNING_NUMBERS);
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBERS);
        }
    }
}
