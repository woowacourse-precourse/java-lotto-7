package lotto.domain;

import java.text.DecimalFormat;

public enum WinningResult {
    Fifth(3, false, 5000, 0),
    Fourth(4, false, 50000, 0),
    Third(5, false, 1500000, 0),
    Second(5, true, 30000000, 0),
    First(6, false, 2000000000, 0);

    private int matchCount;
    private boolean isBonus;
    private int prizeMoney;
    private int winningCount;

    WinningResult(int matchCount, boolean isBonus, int prizeMoney, int winningCount) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.winningCount = winningCount;
    }

    public static String getIntegerWithComma(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getTotalPrize() {
        return prizeMoney * winningCount;
    }

    public void addWinningCount(boolean isContainBonus) {
        if(isContainBonus){
            winningCount++;
        }
    }

    public String getDesc() {
        if (isBonus) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
                    .formatted(matchCount, getIntegerWithComma(prizeMoney), winningCount);
        }
        return "%d개 일치 (%s원) - %d개"
                .formatted(matchCount, getIntegerWithComma(prizeMoney), winningCount);
    }

    public double getPrize() {
        if(isBonus){
        }
        return prizeMoney*winningCount;
    }
}