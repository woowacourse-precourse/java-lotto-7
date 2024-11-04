package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDistinct(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public int countHit(Lotto targetLotto) {
        return (int) numbers.stream()
                .filter(targetLotto::checkHit)
                .count();
    }

    public boolean checkHit(int number) {
        return numbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == number);
    }

    public boolean checkBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public Prize lottoToPrize(int hit, boolean bonus) {
        return Prize.findByHitAndBonus(hit, bonus);
    }

    public String toString() {
        return numbers.toString();
    }
}
