package lotto;

import java.util.List;

public class Lotto {

    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNumberDuplication(numbers);
        this.numbers = numbers;
    }

    public void validateDuplicateByBonusNumber(int bonusNumber) {
        if(!numbers.isEmpty() && numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 포함되어 있는 숫자입니다.");
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
        }
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.stream().map(String::valueOf).toList());
    }
}
