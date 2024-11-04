package lotto.collection;

import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoTickets(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumberWithWinningNumber(WinningNumber winningNumber) {
        List<Integer> getNumbers = winningNumber.getNumbers();
        int count = 0;
        for (int number : numbers) {
            if(getNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberIncludeInWinningNumbers(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
