package lotto.domain;

import lotto.Constants;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int SIZE = 6;
    public static final int MAX_LOTTO_NUMBER = Constants.MAX_LOTTO_NUMBER;
    public static final int MIN_LOTTO_NUMBER = Constants.MIN_LOTTO_NUMBER;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().filter(num -> num <= MAX_LOTTO_NUMBER && num >= MIN_LOTTO_NUMBER).count() != SIZE) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호의 범위는 " + MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + " 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    public LottoGrade match(TargetLotto targetLotto) {
        List<Integer> targetNumbers = targetLotto.lotto().numbers;
        int targetCount = (int) numbers.stream()
                .filter(targetNumbers::contains)
                .count();

        int bonus = targetLotto.bonus();
        int bonusCount = (int) numbers.stream()
                .filter(num -> num == bonus)
                .count();

        return LottoGrade.match(targetCount, bonusCount);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
