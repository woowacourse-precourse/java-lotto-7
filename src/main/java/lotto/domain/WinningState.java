package lotto.domain;

import java.util.stream.Stream;

public enum WinningState {

    UNKNOWN(0, false, 0),
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    WinningState(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static WinningState from(int matchCount, boolean hasBonus) {
        return WinningState.stream()
                .filter(state -> state.matchCount == matchCount)
                .filter(state -> state.hasBonus == hasBonus)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public boolean isWinner() {
        return this != WinningState.UNKNOWN;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }

    public static Stream<WinningState> stream() {
        return Stream.of(WinningState.values());
    }
}