package lotto;

public enum Winning {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    NOT(0, 0, "");

    private Integer matchCount;
    private Integer prizeMoney;
    private String message;

    private Winning(Integer matchCount, Integer prizeMoney, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static Winning findByMatchCount(int matchCount, boolean containBonus) {
        if (SECOND.matchCount == matchCount && containBonus) {
            return SECOND;
        }
        for (Winning winning : Winning.values()) {
            if (winning.getMatchCount() == matchCount && winning != SECOND) {
                return winning;
            }
        }
        return NOT; // 해당 matchCount가 없을 경우 null 반환 (필요시 예외 처리 가능)
    }


    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
