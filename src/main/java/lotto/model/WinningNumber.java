package lotto.model;

import java.util.List;

public class WinningNumber extends Lotto {
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonus_number) {
        super(numbers);
        this.bonusNumber = bonus_number;
    }

    public int getWinningRank(Lotto oneLotto) {
        List<Integer> winningNumber = this.getNumbers();
        int matchedCount = 0;
        boolean matchedBonusNumber = false;

        for (Integer singleNumber : winningNumber) {
            if (oneLotto.getNumbers().contains(singleNumber)) {
                matchedCount++;
            }
        }
        if (oneLotto.getNumbers().contains(bonusNumber)) {
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
