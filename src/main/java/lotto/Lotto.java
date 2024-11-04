package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 null일 수 없습니다.");
        }
        validate(numbers);
        numbers = sortNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 입력되지 않았습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!validateRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45범위 내에 있어야 합니다.");
        }
        if (!validateDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    boolean validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    boolean validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            return false;
        }
        return true;
    }

    List<Integer> sortNumber(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }


}
