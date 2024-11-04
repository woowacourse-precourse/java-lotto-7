package lotto;

public enum Rank {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;  // 일치하는 숫자 개수
    private final int prize;       // 당첨 상금

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    // 상금을 가져오는 메서드
    public int getMoney() {
        return prize;
    }

    // 일치 개수와 보너스 여부에 따른 Rank 반환 메서드
    public static Rank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return SIX_MATCH;
        if (matchCount == 5 && bonusMatch) return FIVE_MATCH_BONUS;
        if (matchCount == 5) return FIVE_MATCH;
        if (matchCount == 4) return FOUR_MATCH;
        if (matchCount == 3) return THREE_MATCH;
        return null;  // 해당하는 등수가 없는 경우
    }
}
