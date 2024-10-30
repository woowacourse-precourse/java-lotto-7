package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numberValidate(numbers);
        rangeValidate(numbers);
        duplicationValidate(numbers);
        this.numbers = numbers;
    }

    public void bonusNumberCheck(int bonusNumber) {
        Set<Integer> bonusCheck = new HashSet<>(numbers);
        if (!bonusCheck.add(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    private void numberValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

    }

    private void rangeValidate(List<Integer> numbers) {
        for (int number : numbers) {

            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 번호는 1과 45 사이의 정수여야 합니다.");
            }
        }
    }

    private void duplicationValidate(List<Integer> numbers) {
        Set<Integer> duplicatedNumber = new HashSet<>(numbers);
        if (duplicatedNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호 중 중복된 숫자가 있습니다.");
        }
    }
}
