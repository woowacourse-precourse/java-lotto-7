package lotto.model;

import java.util.List;

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
            throw new IllegalArgumentException("보너스 번호는 1~45 사이 숫자여야합니다.");
        if (winningNums.getNumbers().contains(bonusNum))
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        return bonusNum;
    }

    public Lotto getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
