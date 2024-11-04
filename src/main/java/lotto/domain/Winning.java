package lotto.domain;

import java.util.Optional;

public enum Winning {
    FIFTH(3, false, "3개 일치 (5,000원) - ", 5_000),
    FOURTH(4, false, "4개 일치 (50,000원) - ", 50_000),
    THIRD(5, false, "5개 일치 (1,500,000원) - ", 1_500_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    FIRST(6, false, "6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private final int matchCount;
    private final boolean bonusExist;
    private final String message;
    private final int prize;

    Winning(int matchCount, boolean bonusExist, String message, int prize) {
        this.matchCount = matchCount;
        this.bonusExist = bonusExist;
        this.message = message;
        this.prize = prize;
    }

    public static Optional<Winning> getWinning(int matchCount, boolean bonusExist) {
        for (Winning winning : values()) {
            if (winning.matchCount == matchCount && winning.bonusExist == bonusExist) {
                return Optional.of(winning);
            }
        }
        return Optional.empty();
    }

    public String getWinningMessage(Integer count) {
        return message + count + "개";
    }

    public int getPrize() {
        return prize;
    }
}
