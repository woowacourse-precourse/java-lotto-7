package lotto.domain.rank.vo;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0,5_000);

    private final int match;
    private final int bonus;
    private final int prize;

    private Rank(int match, int bonus, int prize) {
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Rank of(int match, int bonus) {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}
