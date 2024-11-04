package lotto.domain;

import static lotto.constants.OutputMessage.MATCH_BONUS_MESSAGE_FORMAT;
import static lotto.constants.OutputMessage.MATCH_MESSAGE_FORMAT;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {
    FIFTH(3, 5000, false),
    FOURTH(4, 50000, false),
    THIRD(5, 1500000, false),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000, false);

    private final int matchCount;         // 일치해야 하는 번호 개수
    private final int prize;               // 상금
    private final boolean requiresBonus;   // 보너스 번호 일치 여부

    WinningPrize(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }

    public static Optional<WinningPrize> determineWinningPrize(int matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(WinningPrize.values())
                .filter(prize -> prize.getMatchCount() == matchCount && bonusNumberMatch == prize.requiresBonus())
                .findFirst();
    }

    public String getFormattedMessage(int count, boolean bonusNumberRequired) {
        if (bonusNumberRequired)
            return String.format(MATCH_BONUS_MESSAGE_FORMAT, matchCount, prize, count);

        return String.format(MATCH_MESSAGE_FORMAT, matchCount, prize, count);
    }
}
