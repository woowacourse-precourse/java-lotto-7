package lotto;

public enum Place {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    MISS(0, 0, false);

    public final long prize;
    public final int needHitCount;
    public final boolean needHitBonusNumber;

    private Place(long prize, int needHitCount, boolean needHitBonusNumber) {
        this.prize = prize;
        this.needHitCount = needHitCount;
        this.needHitBonusNumber = needHitBonusNumber;
    }
}
