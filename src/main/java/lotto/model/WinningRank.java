package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public enum WinningRank {

    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCounts;
    private final boolean matchBonus;
    private final int winnings;
    private int count;

    WinningRank(int matchCounts, boolean matchBonus, int winnings) {
        this.matchCounts = matchCounts;
        this.matchBonus = matchBonus;
        this.winnings = winnings;
    }

    public static WinningRank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchCounts == matchCount && rank.matchBonus == matchBonus)
                .findFirst()
                .orElse(null);
    }

    public static void winningCounts(List<Lotto> lottos, LottoChecker checker) {
        for (Lotto lotto : lottos) {
            WinningRank rank = checker.countMatchingNumbers(lotto);
            if (rank != null) {
                rank.increaseCount();
            }
        }
    }

    private void increaseCount() {
        count++;
    }

    private String transferFormat() {
        NumberFormat printWinnings = NumberFormat.getInstance();

        return printWinnings.format(winnings);
    }

    private void printWinnings() {
        System.out.print(matchCounts + "개 일치 ");
        if (matchBonus) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.println(" (" + transferFormat() + "원) - " + count);
    }

    public static void printWinningsResult() {
        for (WinningRank rank : WinningRank.values()) {
            rank.printWinnings();
        }
    }

    public static int calculateTotalWinnings() {
        return Arrays.stream(WinningRank.values())
                .mapToInt(rank -> rank.winnings * rank.count)
                .sum();
    }

}
