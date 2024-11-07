package lotto.model.domain;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningMatch {
    FIRST(2_000_000_000, 6, "6개 일치", 1),
    SECOND(30_000_000, 6, "5개 일치, 보너스 볼 일치", 2),
    THIRD(1_500_000, 5, "5개 일치",
            3),
    FOURTH(50_000, 4, "4개 일치", 4),
    FIFTH(5_000, 3, "3개 일치", 5);

    private final int priceAmount;
    private final int match;
    private final String matchAmount;
    private final int rank;

    WinningMatch(int priceAmount, int match, String matchAmount, int rank) {
        this.priceAmount = priceAmount;
        this.match = match;
        this.matchAmount = matchAmount;
        this.rank = rank;
    }

    public static WinningMatch valueOfRank(int rank) {
        return Arrays.stream(values()).filter(value -> value.rank == rank).findAny().orElse(null);
    }

    public static WinningMatch valueOfMatch(int match) {
        return Arrays.stream(values()).filter(value -> value.match == match).findFirst().orElse(null);
    }

    public static WinningMatch valueOfMinMatch() {
        return Arrays.stream(values()).min(Comparator.comparing(value -> value.match)).orElse(null);
    }

    public static WinningMatch valueOfMaxMatch() {
        return Arrays.stream(values()).max(Comparator.comparing(value -> value.match)).orElse(null);
    }

    public int getPriceAmount() {
        return priceAmount;
    }

    public int getMatch() {
        return match;
    }

    public String getMatchAmount() {
        return matchAmount;
    }

    public int getRank() {
        return rank;
    }
}
