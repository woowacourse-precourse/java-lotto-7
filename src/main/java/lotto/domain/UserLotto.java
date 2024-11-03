package lotto.domain;

import java.util.List;

public class UserLotto {
    private final List<Integer> numbers;
    private WinningRank winningRank;
    private boolean hasBonusNum;

    public UserLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setWinningRank(WinningRank winningRank) {
        this.winningRank = winningRank;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public WinningRank getWinningRank() {
        return winningRank;
    }

    public boolean getHasBonusnum() {
        return hasBonusNum;
    }

    public void setHasBonusNum(int bonusNumber) {
        this.hasBonusNum = numbers.contains(bonusNumber);
    }

}
