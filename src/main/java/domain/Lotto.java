package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (invalidNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자 범위는 1~45까지입니다.");
        }
        if (noDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 6개의 숫자를 뽑아야합니다.");
        }
    }
    private boolean invalidNumber(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                return true;
            }
        }
        return false;
    }
    private boolean noDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}