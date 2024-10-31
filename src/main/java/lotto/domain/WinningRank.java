package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum WinningRank {
    FIRST(6, 2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NONE(0,0);

    private int numOfMatched;
    private int winningMoney;

    WinningRank(int numOfMatched, int winningMoney) {
        this.numOfMatched = numOfMatched;
        this.winningMoney = winningMoney;
    }

    public static WinningRank getWinningRank(int numOfMatched, boolean isBonusNumber) {
        if (numOfMatched < 3) {
            return NONE;
        }

        if (numOfMatched == 5 && isBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(winningRank -> winningRank.numOfMatched == numOfMatched)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int getNumOfMatched() {
        return numOfMatched;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
