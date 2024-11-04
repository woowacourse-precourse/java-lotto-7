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
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또번호는 1~45사이의 정수여야 합니다.");
            }
        }
        List<Integer> check = new ArrayList<>();
        for (int number : numbers) {
            if (check.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호에 중복된 숫자가 존재합니다.");
            }
            check.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
