package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    final List<Integer> numbers; //

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        Set<Integer> checkDuplication = new HashSet<>(numbers);
        if (checkDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되는 숫자가 없어야 합니다.");
        }
    }

}
