package lotto.model;

import java.text.NumberFormat;

public enum WinnerType {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    public static final int UNIT = 1000;
    private static final String LINE_BREAK = "\n";
    private final int matchNumberCount;
    private final boolean hasBonus;
    private final int prize;
    private int count;

    WinnerType(int matchNumberCount, boolean hasBonus, int prize) {
        this.matchNumberCount = matchNumberCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static String information() {
        StringBuilder stringBuilder = new StringBuilder();
        for (WinnerType winnerType : WinnerType.values()) {
            stringBuilder.append(winnerType.matchNumberCount).append("개 일치");
            if (winnerType.hasBonus) {
                stringBuilder.append(", 보너스 볼 일치");
            }
            String numberFormat = NumberFormat.getInstance().format(winnerType.prize);
            stringBuilder.append(" (").append(numberFormat).append("원)");
            stringBuilder.append(" - ").append(winnerType.count).append("개");
            stringBuilder.append(LINE_BREAK);
        }
        return stringBuilder.toString();
    }

    public static double calculateRateOfReturn(int lottoCount) {
        int investmentAmount = lottoCount * UNIT;
        int profit = 0;
        for (WinnerType winnerType : WinnerType.values()) {
            if (winnerType.count > 0) {
                profit += winnerType.prize * winnerType.count;
            }
        }
        return ((double) profit / investmentAmount) * 100;
    }

    public void increaseCount() {
        count++;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }
}