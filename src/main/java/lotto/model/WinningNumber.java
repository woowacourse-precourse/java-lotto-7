package lotto.model;

import java.util.List;

public class WinningNumber extends Lotto {
    private int bonus_number;

    public WinningNumber(List<Integer> numbers, int bonus_number) {
        super(numbers);
        this.bonus_number = bonus_number;
    }

    public int getWinningRank(List<Integer> lotto) {
        List<Integer> winningNumber = this.getNumbers();
        int matchedCount = 0;
        boolean matchedBonusNumber = false;

        for (Integer singleNumber : winningNumber) {
            if (lotto.contains(singleNumber)) {
                matchedCount++;
            }
        }
        if (lotto.contains(bonus_number)) {
            matchedBonusNumber = true;
        }

        if (matchedCount >= 0 && matchedCount <= 2) {
            return 0;
        }
        if (matchedCount == 3) {
            return 5;
        }
        if (matchedCount == 4) {
            return 4;
        }
        if (matchedCount == 5 && !matchedBonusNumber) {
            return 3;
        }
        if (matchedCount == 5 && matchedBonusNumber) {
            return 2;
        }
        return 1;
    }
}
