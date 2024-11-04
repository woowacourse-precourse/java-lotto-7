package lotto.model;

import java.util.Arrays;

public enum Rank {

    LOSE(0L, "", 0),
    FIFTH(5_000L, "3개 일치 (5,000원)", 3),
    FOURTH(50_000L, "4개 일치 (50,000원)", 4),
    THIRD(1_500_000L, "5개 일치 (1,500,000원)", 5),
    SECOND(30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)", 5),
    FIRST(2_000_000_000L, "6개 일치 (2,000,000,000원)", 6);

    private static final String DELIMITER = " - ";
    private static final String UNIT = "개";

    private final long prize;
    private final String message;
    private final int correctCont;

    Rank(long prize, String message, int correctCont) {
        this.prize = prize;
        this.message = message;
        this.correctCont = correctCont;
    }

    public static Rank determineRank(int correctCont, boolean containBonusNumber) {
        if (correctCont == 5 && containBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.correctCont == correctCont)
                .findFirst()
                .orElse(LOSE);
    }

    public String getMessage(int count) {
        return message + DELIMITER + count + UNIT;
    }

    public long getPrize() {
        return prize;
    }
}
