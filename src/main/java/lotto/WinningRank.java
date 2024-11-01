package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public enum WinningRank {
    FAIL(-1, -1, 0, ""),
    FIFTH(5, 3, 5000, "5,000"),
    FOURTH(4, 4, 50000, "50,000"),
    THIRD(3, 5, 1500000, "1,500,000"),
    SECOND(2, 5, 30000000, "30,000,000"),
    FIRST(1, 6, 2000000000, "2,000,000,000");

    private final int rank;
    private final int matchingAmount;
    private final int price;
    private final String priceString; //리팩토링 예정

    WinningRank(int rank, int matchingAmount, int price, String priceString) {
        this.rank = rank;
        this.matchingAmount = matchingAmount;
        this.price = price;
        this.priceString = priceString;
    }

    public static WinningRank findWinningStatusByMatchingAmount(int matchingAmount, boolean matchesBonusNumber) {
        for (WinningRank winningRank : WinningRank.values()) {
            if (matchingAmount == winningRank.matchingAmount) {
                return findWinningStatus(winningRank, matchingAmount, matchesBonusNumber);
            }
        }
        return FAIL;
    }

    public static WinningRank findWinningStatus(WinningRank winningRank, int matchingAmount, boolean matchesBonusNumber) {
        if (matchingAmount == 5) {
            if (matchesBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        return winningRank;
    }

    public static List<WinningRank> findWinningRanksInAscendingOrder() {
        List<WinningRank> winningRanks = new ArrayList<>(List.of(WinningRank.values()));
        winningRanks.remove(WinningRank.FAIL);
        winningRanks.sort(Comparator.comparingInt(WinningRank::getRank).reversed());
        return winningRanks;
    }

    public static String findMatchingAmountMessage(WinningRank winningRank) {
        if (winningRank == WinningRank.SECOND) {
            return "%d개 일치, 보너스 볼 일치 ";
        }
        return "%d개 일치 ";
    }

    private int getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchingAmount() {
        return matchingAmount;
    }

    public String getPriceString() {
        return priceString;
    }
}
