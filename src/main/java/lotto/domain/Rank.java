package lotto.domain;

public enum Rank {
    FIRST("1등", 2_000_000_000),
    SECOND("2등", 30_000_000),
    THIRD("3등", 1_500_000),
    FOURTH("4등", 50_000),
    FIFTH("5등", 5_000);

    private final String label;
    private final long prize;

    Rank(String label, long prize) {
        this.label = label;
        this.prize = prize;
    }

    public String getLabel(){
        return label;
    }

    public long getPrize(){
        return prize;
    }
}
