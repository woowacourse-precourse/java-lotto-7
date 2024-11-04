package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public Integer getMatchingNumberCount(List<Integer> numbers, Integer bonusNumber) {
        numbers.retainAll(this.numbers);
        return numbers.size();
    }

    public boolean isBonusNumberMatching(Integer bonusNumber) {
        return numbers.stream()
                .anyMatch(n -> n.equals(bonusNumber));
    }
}
