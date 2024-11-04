package lotto.constant;

import java.util.List;
import lotto.model.WinningCondition;

public enum WinningType {
    FIRST(new WinningCondition(6, false), 2000000000L),
    SECOND(new WinningCondition(5, true), 30000000L),
    THIRD(new WinningCondition(5, false), 1500000L),
    FOURTH(new WinningCondition(4, false), 50000L),
    FIFTH(new WinningCondition(3, false), 5000L),
    NONE(new WinningCondition(0, false), 0L);

    private final WinningCondition condition;
    private final Long prizeMoney;

    WinningType(WinningCondition condition, Long prizeMoney) {
        this.condition = condition;
        this.prizeMoney = prizeMoney;
    }

    public static WinningType checkType(int matchedNumberCount, boolean isBonusNumberMatched) {
        List<WinningType> winningTypes = List.of(WinningType.values());
        return winningTypes.stream()
                .filter(type -> type.getCondition().checkWinning(matchedNumberCount, isBonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }

    public WinningCondition getCondition() {
        return condition;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }
}
