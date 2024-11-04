package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Ranking {
    FIRST("6개 일치 (2,000,000,000원) - ", 2_000_000_000, 6, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000, 5, true),
    THIRD("5개 일치 (1,500,000원) - ", 1_500_000, 5, false),
    FOURTH("4개 일치 (50,000원) - ", 50_000, 4, false),
    FIFTH("3개 일치 (5,000원) - ", 5_000, 3, false);

    private final String rankResult;
    private final int prize;
    private final int matchCount;
    private final boolean matchBonus;

    Ranking(String rankResult, int prize, int matchCount, boolean matchBonus) {
        this.rankResult = rankResult;
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public String getRankResult() {
        return rankResult;
    }

    public int getPrize() {
        return prize;
    }

    private int getMatchCount() {
        return matchCount;
    }

    private boolean isBonusMatch() {
        return matchBonus;
    }

    public static Optional<Ranking> findByMatchCountAndBonus(int matchCount, boolean matchBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getMatchCount() == matchCount && ranking.isBonusMatch() == matchBonus)
                .findFirst();
    }
}
