package lotto;

import java.text.NumberFormat;

public enum WinningRank {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int winnings;
    private final int matchCounts;
    private final boolean matchBonus;

    WinningRank(int matchCounts, boolean matchBonus, int winnings) {
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
        this.winnings = winnings;
    }

    private String transferFormat() {
        NumberFormat printWinnings = NumberFormat.getInstance();

        return printWinnings.format(winnings);
    }

    public static void printWinnings(WinningRank rank) {
        System.out.println(rank.matchCounts + "개 일치 ");
        if (rank.matchBonus) {
            System.out.println(", 보너스 볼 일치");
        }
        System.out.println(" (" + rank.transferFormat() + "원) - ");
    }

    public int getWinnings() {
        return winnings;
    }

}
