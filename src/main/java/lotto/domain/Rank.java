package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prize;
    private final String message;

    Rank(int matchCount, boolean isBonusMatch, int prize, String message) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prize = prize;
        this.message = message;
    }

    public static Rank rank(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchCount, isBonusMatch))//일치하는걸 찾고
                .findFirst()
                .orElse(NONE);//없으면 NONE
    }

    public int getPrize() {
        return prize;
    }

    public String createMessage(Integer count) {
        return String.format(this.message, count);
    }

    private boolean matches(int matchCount, boolean isBonusMatch) {
        return this.matchCount == matchCount//갯수가 일치하고
                && (!this.isBonusMatch || isBonusMatch);// 보너스 번호 일치 여부가 같다
    }
}
