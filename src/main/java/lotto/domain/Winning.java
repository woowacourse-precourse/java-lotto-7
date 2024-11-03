package lotto.domain;

import static lotto.constant.Error.DUPLICATED_WINNING_BONUS_NUMBERS;
import static lotto.constant.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.Error.RANGE_BONUS_NUMBER;
import static lotto.constant.Error.RANGE_WINNING_NUMBER;
import static lotto.constant.Error.SIZE_WINNING_NUMBERS;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;
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
        validateBonusNumber(bonusNumber);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_BONUS_NUMBERS);
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != SIZE_NUMBERS) {
            throw new IllegalArgumentException(SIZE_WINNING_NUMBERS);
        }

        if (numbers.stream().anyMatch(
            number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(RANGE_WINNING_NUMBER);
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBERS);
        }
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(RANGE_BONUS_NUMBER);
        }
    }
}
