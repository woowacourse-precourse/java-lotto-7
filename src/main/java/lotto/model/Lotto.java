package lotto.model;

import java.util.Iterator;
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

    public Iterator<Integer> getNumbers() {
        return numbers.iterator();
    }

    public LottoResult getMatchedLottoResult(Iterator<Integer> winningNumbers, BonusNumber bonusNumber) {
        int count = 0;
        boolean hasBonusNumber = this.contains(bonusNumber.getNumber());

        while (winningNumbers.hasNext()) {
            if (this.contains(winningNumbers.next())) {
                count++;
            }
        }

        return new LottoResult(count, hasBonusNumber);
    }

    private boolean contains(int number) {
        return numbers.contains(number);
    }
}
