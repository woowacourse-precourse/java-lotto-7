package lotto;

import java.util.List;
import lotto.common.Winning;

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

    // TODO: 추가 기능 구현
    public Winning checkWinnings(List<Integer> winningNumbers, int bonus) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        if (count == 5 && numbers.contains(bonus)) {
            count = 7;
        }

        return Winning.of(count);
    }
}
