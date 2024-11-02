package lotto;

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
    }

    public void display() {
        System.out.println(this.numbers);
    }

    public int match(List<Integer> winningLotto) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        numbersSet.retainAll(winningLotto);

        return numbersSet.size();
    }
}
