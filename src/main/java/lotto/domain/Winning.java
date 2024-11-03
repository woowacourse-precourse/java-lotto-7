package lotto.domain;

import java.util.HashSet;

public class Winning {
    private HashSet<Integer> winningNumbers;
    private int bonusNumber;

    public Winning() {
        this.winningNumbers = new HashSet<>();
        this.bonusNumber = 0;
    }

    public Winning(HashSet<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public HashSet<Integer> setHashSet(HashSet<Integer> winningNumberSet) {
        return this.winningNumbers = winningNumberSet;
    }

    public int setBonusNumber(int bonusNumber) {
        return this.bonusNumber = bonusNumber;
    }
}
