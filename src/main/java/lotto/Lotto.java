package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoGenerator.MIN_NUMBER;
import static lotto.LottoGenerator.MAX_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        countValidation(numbers);
        for (Integer number : numbers) rangeValidation(number);
        DuplicationValidate(numbers);
    }

    private void countValidation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void rangeValidation(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 숫자입니다.");
        }
    }

    private void DuplicationValidate(List<Integer> numbers) {
        Set<Integer> distinctedNumbers = new HashSet<>(numbers);
        if (distinctedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호들은 서로 중복되지 않아야 합니다.");
        }
    }
}
