package lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public enum WinningRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_WINNING(0, 0);

    private static final Map<Predicate<WinningStatus>, WinningRank> RANK_MAP = new LinkedHashMap<>() {{
        put(winningStatus -> winningStatus.getMatchedNumberCount() == 6, FIRST);
        put(winningStatus -> winningStatus.getMatchedNumberCount() == 5 && winningStatus.isBonusNumberMatched(),
                WinningRank.SECOND);
        put(winningStatus -> winningStatus.getMatchedNumberCount() == 5, WinningRank.THIRD);
        put(winningStatus -> winningStatus.getMatchedNumberCount() == 4, WinningRank.FOURTH);
        put(winningStatus -> winningStatus.getMatchedNumberCount() == 3, WinningRank.FIFTH);
    }};

    private final int matchedNumberCount;
    private final int money;
    private final boolean requiresBonus;

    WinningRank(final int matchedNumberCount, final int money) {
        this(matchedNumberCount, money, false);
    }

    WinningRank(final int matchedNumberCount, final int money, final boolean requiresBonus) {
        this.matchedNumberCount = matchedNumberCount;
        this.money = money;
        this.requiresBonus = requiresBonus;
    }

    public static WinningRank from(final WinningStatus winningStatus) {
        return RANK_MAP.entrySet().stream()
                .filter(
                        rank -> rank
                                .getKey()
                                .test(winningStatus)
                )
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(NO_WINNING);
    }
}
