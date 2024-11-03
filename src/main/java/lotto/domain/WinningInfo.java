package lotto.domain;

import static lotto.domain.LottoInfo.PICK_COUNT;

public enum WinningInfo {

    FIFTH(5, 3, 5_000),
    FOURTH(4, 4, 50_000),
    THIRD(3, 5, 1_500_000),
    SECOND(2, 5, 30_000_000),
    FIRST(1, 6, 2_000_000_000);

    private final int place;
    private final int matchingNumberCount;
    private final int prizeMoney;
    private int winningTicketCount;

    WinningInfo(int place, int matchingNumberCount, int prizeMoney) {
        this.place = place;
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public static void resetWinningTicketCount() {
        for (WinningInfo info : WinningInfo.values()) {
            info.winningTicketCount = 0;
        }
    }

    public void win() {
        winningTicketCount++;
    }

    public int getPlace() {
        return place;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getWinningTicketCount() {
        return winningTicketCount;
    }
}
