package lotto;

import static lotto.constant.ErrorMessage.NOT_SIX_WINNING_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.DuplicateWinningNumberException;

public class Lotto {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int compareWinningNumbers(WinningNumbers winningNumbers) {
        int sameNumberCount = 0;
        for (int winningNumber : winningNumbers.loadWinningNumbers()) {
            if (numbers.contains(winningNumber)) {
                sameNumberCount++;
            }
        }

        return sameNumberCount;
    }

    public int compareBonusNumber(BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.loadBonusNumber())) {
            return 1;
        }
        return 0;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_SIX_WINNING_NUMBER.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().toList().size()) {
            throw new DuplicateWinningNumberException();
        }
    }


    public String printLottoNumbers() {
        return numbers.toString();
    }
}
