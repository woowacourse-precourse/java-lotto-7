package lotto.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "0개 일치");

    private final int matchCount;     // 일치하는 숫자의 개수
    private final boolean matchBonus; // 보너스 숫자 일치 여부
    private final int prizeMoney;     // 당첨 상금
    private final String displayName; // 출력용 등수 이름

    // 생성자 - 등수별 매칭 조건과 상금, 이름 초기화
    Rank(int matchCount, boolean matchBonus, int prizeMoney, String displayName) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeMoney = prizeMoney;
        this.displayName = displayName;
    }

    // 당첨 상금을 반환
    public int getPrizeMoney() {
        return prizeMoney;
    }

    // 등수의 이름을 반환
    public String getDisplayName() {
        return displayName;
    }

    // 일치 개수와 보너스 여부에 따라 Rank(등수) 반환
    public static Rank of(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE; // 일치 개수가 부족한 경우 NONE 반환
    }
}
