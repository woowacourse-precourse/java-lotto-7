package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validation(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> validation(List<Integer> numbers) {

        numberValidate(numbers);
        rangeValidate(numbers);
        duplicationValidate(numbers);

        return numbers;
    }

    private void numberValidate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)로 구분된 6개의 정수여야 합니다.");
        }

    }

    private void rangeValidate(List<Integer> numbers) {

        for (int number : numbers) {

            if (!(1 <= number && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 정수여야 합니다.");
            }

        }
    }

    private void duplicationValidate(List<Integer> numbers) {

        Set<Integer> duplicatedNumber = new HashSet<>(numbers);

        if (duplicatedNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 중복된 숫자가 있습니다.");
        }

    }
}
