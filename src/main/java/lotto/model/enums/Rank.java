package lotto.model.enums;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIFTH("3개 일치", 3),
    FOURTH("4개 일치", 4),
    THIRD("5개 일치", 5),
    SECOND("5개 일치, 보너스 볼 일치", 5),
    FIRST("6개 일치", 6),
    NONE("꽝", 0)
    ;

    private final String message;
    private final Integer match;

    Rank(String message, int match) {
        this.message = message;
        this.match = match;
    }

    public String getMessage() {
        return message;
    }

    public boolean isNone() {
        return this == NONE;
    }

    public static Map<Rank, Long> groupByRank(List<Rank> ranks) {
        return ranks.stream()
                .filter(rank -> !rank.isNone())
                .collect(Collectors.groupingBy(rank -> rank,
                        () -> new EnumMap<>(Rank.class),
                        Collectors.counting()));
    }

    public static Rank checkRank(long match, boolean bonus) {
        if (match == FIRST.match) {
            return FIRST;
        }
        if (match == SECOND.match) {
            if (bonus) {
                return SECOND;
            }
            return THIRD;
        }
        if (match == FOURTH.match) {
            return FOURTH;
        }
        if (match == FIFTH.match) {
            return FIFTH;
        }
        return NONE;
    }
}
