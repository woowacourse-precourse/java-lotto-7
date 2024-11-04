package lotto.domain;

import java.util.HashSet;

public class Winning {
    private HashSet<Integer> winningSet;
    private int bonusNumber;

    public Winning() {
        this.winningSet = new HashSet<Integer>();
        this.bonusNumber = 0;
    }

    public Winning(HashSet<Integer> winningNumbers, int bonusNumber) {
        this.winningSet = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public HashSet<Integer> getWinningSet() {
        return winningSet;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setHashSet(HashSet<Integer> winningNumberSet) {
        this.winningSet = winningNumberSet;
    }
}
