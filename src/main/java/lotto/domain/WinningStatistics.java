package lotto.domain;

public enum WinningStatistics {

    FIFTH(3, 5_000, 0),
    FOURTH(4, 50_000, 0),
    THIRD(5, 1_500_000, 0),
    SECOND(5, 30_000_000, 0),
    FIRST(6, 2_000_000_000, 0);

    private final int match;
    private final int price;
    private int count;

    WinningStatistics(final int match, final int price, final int count) {
        this.match = match;
        this.price = price;
        this.count = count;
    }

    public int getMatchValue() {
        return match;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public static void updateCount(final int value, boolean bonusNumber) {
        WinningStatistics[] winningSets = WinningStatistics.values();

        for (WinningStatistics statistics : winningSets) {

            if (statistics.match == SECOND.match && statistics.match == value && bonusNumber) {
                statistics.count++;
                return;
            }

            if (statistics.match == value) {
                statistics.count++;
            }
        }
    }
}
