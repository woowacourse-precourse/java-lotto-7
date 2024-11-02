package lotto.model;

import java.util.Comparator;
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

        for (Integer number : numbers) {
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이어야 합니다.");
            }
        }

        Set<Integer> numbersSet = new HashSet<>(numbers);
        if(numbers.size() != numbersSet.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 6개여야 합니다.");
        }
    }
    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
