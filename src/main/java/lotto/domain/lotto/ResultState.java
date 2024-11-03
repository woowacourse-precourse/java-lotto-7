package lotto.domain.lotto;

import java.util.stream.Stream;
import lotto.domain.winner.MessageProvider;

public enum ResultState implements MessageProvider {

    UNKNOWN(0, false, 0),
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000) {
        @Override
        public String provideMessage(int count) {
            return String.format(MATCH_WITH_BONUS_TEMPLATE, getMatchCount(), getPrize(), count);
        }
    },
    SIX(6, false, 2_000_000_000);

    private static final String MATCH_TEMPLATE = "%d개 일치 (%,d원) - %d개";
    private static final String MATCH_WITH_BONUS_TEMPLATE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    ResultState(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static ResultState from(int matchCount, boolean hasBonus) {
        return ResultState.defaultStream()
                .filter(state -> state.matchCount == matchCount)
                .filter(state -> state.hasBonus == hasBonus)
                .findFirst()
                .orElse(UNKNOWN);
    }

    public boolean isWinner() {
        return this != ResultState.UNKNOWN;
    }

    public int calculatePrize(int count) {
        return this.prize * count;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    @Override
    public String provideMessage(int count) {
        return String.format(MATCH_TEMPLATE, this.matchCount, this.prize, count);
    }

    public static Stream<ResultState> defaultStream() {
        return Stream.of(ResultState.values());
    }

    public static Stream<ResultState> winnerStream() {
        return defaultStream().filter(ResultState::isWinner);
    }
}