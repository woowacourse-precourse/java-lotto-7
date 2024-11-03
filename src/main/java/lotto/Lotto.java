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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int checkNumbers(Lotto winningLotto) {
        int correctCnt = 0;

        for (int num : numbers) {
            if (winningLotto.numbers.contains(num)) {
                correctCnt++;
            }
        }

        return correctCnt;
    }

    public int checkBonus(int bonusNumber) {
        if (numbers.contains(bonusNumber)) return 1;
        return 0;
    }
}