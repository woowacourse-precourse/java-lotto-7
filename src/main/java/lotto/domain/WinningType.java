package lotto.domain;

public enum WinningType {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prize;
    private final String message;

    WinningType(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 당첨 번호 일치 개수와 보너스 번호 일치 여부에 따라 당첨 유형을 반환 해주는 메서드
     * @param matchCount 당첨 번호가 일치한 개수
     * @param bonusMatched 보너스 번호가 일치한지 검증
     * @return 당첨 번호가 일치하는 만큼의 enum 값을 반환(없을 경우 null 반환)
     */
    public static WinningType valueOf(int matchCount, boolean bonusMatched) {
        if (matchCount == 5 && bonusMatched) {
            return FIVE_MATCH_WITH_BONUS;
        }
        for (WinningType type : values()) {
            if (type.matchCount == matchCount) {
                return type;
            }
        }
        return null;
    }
}
