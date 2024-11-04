package lotto;

import java.util.ArrayList;
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

        duplicationValidate(numbers);
    }

    private void duplicationValidate(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();

        if(count != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
        }
    }

    public Integer getMatchingNumberCount(List<Integer> numbers) {
        ArrayList<Integer> numberList = new ArrayList<>(numbers);
        numberList.retainAll(this.numbers);
        return numberList.size();
    }

    public boolean isBonusNumberMatching(Integer bonusNumber) {
        return numbers.stream()
                .anyMatch(n -> n.equals(bonusNumber));
    }
}
