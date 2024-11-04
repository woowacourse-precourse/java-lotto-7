package lotto.rank;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    MATCH_3(3, false, 5_000, "3개 일치 (5,000원) - %d개\n"),
    MATCH_4(4, false, 50_000, "4개 일치 (50,000원) - %d개\n"),
    MATCH_5(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    MATCH_5_BONUS(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    MATCH_6(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n"),
    NONE(0, false, 0, "");

    private final long matchCount;
    private final boolean bonusMatch;
    private final long prize;
    private final String rankFormat;

    Rank(long matchCount, boolean bonusMatch, long prize, String rankFormat) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.rankFormat = rankFormat;
    }

    public static Rank valueOf(long matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusMatch == bonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    public static List<Rank> getOrderedRanks() {
        return Arrays.asList(Rank.values());
    }

    public long getPrize() {
        return prize;
    }

    public String getRankFormat() {
        return rankFormat;
    }

}