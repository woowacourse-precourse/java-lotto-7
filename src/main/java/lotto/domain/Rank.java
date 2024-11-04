package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, false, 0, "");

    private int matchedNumberCount;
    private boolean matchesBonusNumber;
    private int winningMoney;
    private String message;

    private Rank(int matchedNumberCount, boolean matchesBonusNumber, int winningMoney, String message) {
        this.matchedNumberCount = matchedNumberCount;
        this.matchesBonusNumber = matchesBonusNumber;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank of(int matchedNumberCount, boolean matchesBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchedNumberCount == matchedNumberCount
                                && rank.matchesBonusNumber == matchesBonusNumber)
                .findAny().orElse(MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getMessage() {
        return message;
    }
}
