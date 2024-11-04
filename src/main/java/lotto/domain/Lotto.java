package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().filter(num -> num <= 45 && num >= 1).count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다.");
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
