package lotto.model;

import java.util.List;

import static lotto.constant.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_BONUS_NUMBER_RANGE;
import static lotto.provider.NumberProvider.MAX_NUMBER;
import static lotto.provider.NumberProvider.MIN_NUMBER;

public class WinningLotto {
    private final Lotto winningNums;
    private final int bonusNum;

    public WinningLotto(List<Integer> inputNums, int bonusNum) {
        this.winningNums = validateAndReturnWinningNums(inputNums);
        this.bonusNum = validateAndBonusNum(bonusNum);
    }

    private Lotto validateAndReturnWinningNums(List<Integer> winningNums) {
        return new Lotto(winningNums);
    }

    private int validateAndBonusNum(int bonusNum) {
        return validateAndReturnBonusNum(bonusNum);
    }

    private int validateAndReturnBonusNum(int bonusNum) {
        if (bonusNum < MIN_NUMBER || bonusNum > MAX_NUMBER)
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        if (winningNums.getNumbers().contains(bonusNum))
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        return bonusNum;
    }

    public Lotto getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
