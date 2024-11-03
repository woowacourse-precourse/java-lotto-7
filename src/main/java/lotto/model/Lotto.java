package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasNotNumberRanged(numbers) || hasDuplicationNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 중복되지 않은 자연수 6개여야 합니다.");
        }
    }
    private boolean hasNotNumberRanged(List<Integer> numbers){
        for (int number : numbers){
            if (number < 0 || number > 45){
                return true;
            }
        }
        return false;
    }
    private boolean hasDuplicationNumber(List<Integer> numbers){
        Set<Integer> uniqueNames = new HashSet<>(numbers);
        if (uniqueNames.size() < numbers.size()) {
            return true;
        }
        return false;
    }
}
