package lotto;

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

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public Grade compare(Lotto winningLotto, int bonusNumber) {
        int count = 0;
        boolean bonusCount = false;

        for (int number : numbers) {
            if (winningLotto.contains(number)) {
                count++;
            }
            if (number == bonusNumber) {
                bonusCount = true;
            }
        }

        return Grade.valueOf(count, bonusCount);
    }

}
