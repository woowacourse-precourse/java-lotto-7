package lotto.enums;

public enum WinningStatistics {
    FIRST(6, 2000000000,"6개 일치 (2,000,000,000원) - %d개\n", 0),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 0),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개\n", 0),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개\n", 0),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개\n", 0);

    private final int matchCount;
    private final int prize;
    private final String description;
    private int count;

    WinningStatistics(int matchCount, int prize, String description,int count) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
        this.count = count;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getDescription() {
        return this.description;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
