package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private static final Map<List<Object>, Rank> RANK_MAP;

    static {
        RANK_MAP = Arrays.stream(values())
                .collect(Collectors.toMap(
                        rank -> List.of(rank.matchCount, rank.matchBonus),
                        rank -> rank
                ));
    }

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank calculateRank(int matchCount, boolean matchBonus) {
        return RANK_MAP.getOrDefault(List.of(matchCount, matchBonus), NONE);
    }
}