package lotto.model;

import static lotto.constant.ExceptionMessage.INVALID_LOTTO_COUNT;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_DUPLICATE;
import static lotto.constant.ExceptionMessage.INVALID_LOTTO_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final static int MIN_LOTTO_NUM = 1;
    private final static int MAX_LOTTO_NUM = 45;
    private final static int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(INVALID_LOTTO_RANGE.getMessage());
            }
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(INVALID_LOTTO_DUPLICATE.getMessage());
        }
    }

    public static Lotto randomCreate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public int calculateDrawResult(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public boolean hasBonusNum(int bonusNum) {
        return this.numbers.contains(bonusNum);
    }
}
