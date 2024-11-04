package lotto;

import java.util.List;

import static lotto.LottoMachine.LOTTO_NUMBER_COUNT;
import static lotto.LottoMachine.LOTTO_MIN_RANGE;
import static lotto.LottoMachine.LOTTO_MAX_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int num : numbers) {
            if (num < LOTTO_MIN_RANGE || num > LOTTO_MAX_RANGE) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 없어야 합니다.");
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

    public boolean checkBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}