package lotto.domain;

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

    public int calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        long match = numbers.stream().filter(winningNumbers::contains).count();
        boolean bonusNumberFlag = numbers.contains(bonusNumber);
        if (match == 3) {
            return 5;
        }
        if (match == 4) {
            return 4;
        }
        if (match == 5) {
            if(!bonusNumberFlag) {
                return 3;
            }
            return 2;
        }
        if (match == 6) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().toList().toString();
    }
}
