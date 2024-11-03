package lotto.domain;

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

    // TODO: 추가 기능 구현
    public LottoGrade match(Lotto targetLotto, int bonus) {
        int targetCount = (int) numbers.stream()
                .filter(num -> targetLotto.numbers.contains(num))
                .count();

        int bonusCount = (int) numbers.stream()
                .filter(num -> num == bonus)
                .count();

        return LottoGrade.match(targetCount, bonusCount);
    }
}
