package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForDuplicates(numbers);
        checkForMinusAndZero(numbers);
        checkForUpperBound(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    //중복된 값을 처리하는 기능
    private void checkForDuplicates(List<Integer> numbers) {
        //HashSet은 중복된 값을 갖지 않는다는 것을 이용
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 값이 없어야 합니다.");
        }
    }

    private void checkForMinusAndZero(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에는 0이 포함되어서는 안됩니다.");
            }
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에는 음수 값이 포함되어서는 안됩니다.");
            }
        }
    }

    private void checkForUpperBound(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.");
            }
        }
    }
}
