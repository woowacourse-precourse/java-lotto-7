package lotto.model;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    private final int matchCount; // 일치하는 번호 개수
    private final int prize; // 당첨 금액
    private final boolean requireBonus; // 보너스 번호 요구 여부

    Rank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    Rank(int matchCount, int prize, boolean requireBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requireBonus = requireBonus;
    }

    // 로또와 당첨 로또를 비교하여 Rank를 반환
    public static Rank valueOf(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = lotto.matchCount(winningLotto.getWinningNumbers());
        boolean bonusMatch = lotto.contains(winningLotto.getBonusNumber());

        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isRequireBonus() {
        return requireBonus;
    }
}
