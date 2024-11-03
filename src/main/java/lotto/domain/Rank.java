package lotto.domain;

public enum Rank {
    FIFTH("3개 일치", 3, 5_000),
    FOURTH("4개 일치", 4, 50_000),
    THIRD("5개 일치", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000),
    FIRST("6개 일치", 6, 2_000_000_000);

    private final String label;
    private final int matchCount;
    private final long prize;

    Rank(String label, int matchCount, long prize) {
        this.label = label;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String getLabel(){
        return label;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize(){
        return prize;
    }
}
