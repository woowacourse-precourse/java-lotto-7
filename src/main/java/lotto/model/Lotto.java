package lotto.model;

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
    }

    public Prize checkResult(List<Integer> winningNumbers, Integer bonusNumber) {
        Integer count = 0;
        Boolean bonus = false;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number))
                count++;

            if (number.equals(bonusNumber)) {
                bonus = true;
            }
        }

        return Prize.getResult(count, bonus);
    }
}
