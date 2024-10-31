package lotto.domain.winning;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum WinningRank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5,1500000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4,50000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3,5000,"3개 일치 (5,000원) - %d개"),
    NONE(0,0, "0개 일치");

    private int numOfMatched;
    private int winningMoney;
    private String winningString;

    WinningRank(int numOfMatched, int winningMoney, String winningString) {
        this.numOfMatched = numOfMatched;
        this.winningMoney = winningMoney;
        this.winningString = winningString;
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

    public String getWinningString() {
        return winningString;
    }
}
