package lotto;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),    // 6개 일치
    SECOND(5, true, 30_000_000),        // 5개 + 보너스 일치
    THIRD(5, false, 1_500_000),         // 5개 일치
    FOURTH(4, false, 50_000),           // 4개 일치
    FIFTH(3, false, 5_000),             // 3개 일치
    NONE(0, false, 0);                  // 꽝

    private final int matchCount;        // 일치하는 번호 개수
    private final boolean matchBonus;    // 보너스 번호 일치 여부
    private final int prize;             // 당첨 상금

    // 생성자
    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    // 당첨금 반환 메서드
    public int getPrize() {
        return prize;
    }
    
    // 매치된 개수 반환 메소드
    public int getMatchCount() {return matchCount;}

    // 맞는 당첨 등수 반환 메서드
    public static LottoRank getRank(int matchCount, boolean matchBonus) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }
}
