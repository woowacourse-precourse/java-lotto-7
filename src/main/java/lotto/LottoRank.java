package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matches = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        if (matches == 6) return FIRST;
        if (matches == 5 && lotto.getNumbers().contains(bonusNumber)) return SECOND;
        if (matches == 5) return THIRD;
        if (matches == 4) return FOURTH;
        if (matches == 3) return FIFTH;
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}