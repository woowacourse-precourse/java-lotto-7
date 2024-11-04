package lotto.constants;

public enum Ranking {

    ZERO(0, 0, "0", false),
    ONE(0, 0, "0", false),
    TWO(0, 0, "0", false),
    THREE(3, 5000, "5,000", true),
    FOUR(4, 50000, "50,000", true),
    FIVE(5, 1500000, "1,500,000", true),
    FIVE_BONUS(5, 30000000, "30,000,000", true),
    SIXTH(6, 2000000000, "2,000,000,000", true);

    final private int count;
    final private int winnings;
    final private String strWinnings;
    final private boolean isWinning;

    Ranking(int count, int winnings, String strWinnings, boolean isWinning) {
        this.count = count;
        this.winnings = winnings;
        this.strWinnings = strWinnings;
        this.isWinning = isWinning;
    }

    public int getCount() {
        return count;
    }

    public int getWinnings() {
        return winnings;
    }

    public String getStrWinnings() {
        return strWinnings;
    }

    public boolean isWinning() {
        return isWinning;
    }
}
