package lotto.domain;

import java.util.HashSet;

public class Winning {
    private HashSet<Integer> winningSet;
    private int bonusNumber;

    public Winning() {
        this.winningSet = new HashSet<>();
        this.bonusNumber = 0;
    }

    public Winning(HashSet<Integer> winningNumbers, int bonusNumber) {
        this.winningSet = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public HashSet<Integer> getWinningSet() {
        return winningSet;
    }

    public HashSet<Integer> setHashSet(HashSet<Integer> winningNumberSet) {
        return this.winningSet = winningNumberSet;
    }

    public int setBonusNumber(int bonusNumber) {
        return this.bonusNumber = bonusNumber;
    }
}
