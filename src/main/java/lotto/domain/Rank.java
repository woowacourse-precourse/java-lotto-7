package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIFTH(3, false, 5_000, "3개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2_000_000_000, "6개 일치");

    private final Integer match;
    private final Boolean isMatchedBonus;
    private final Integer prize;
    private final String message;

    Rank(Integer match, Boolean isMatchedBonus, Integer prize, String message) {
        this.match = match;
        this.isMatchedBonus = isMatchedBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Rank calculateRank(Integer match, Boolean isMatchedBonus) {

        if (SECOND.match.equals(match) && SECOND.isMatchedBonus.equals(isMatchedBonus)) {
            System.out.println(isMatchedBonus);
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match.equals(match))
                .findFirst()
                .orElse(null);
    }

    public Integer getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

}
