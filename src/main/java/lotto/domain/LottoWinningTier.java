package lotto.domain;

import java.util.Arrays;

import static lotto.constants.LottoConstants.MATCH_FIVE_COUNT;

public enum LottoWinningTier {
    NONE(0, 0, null),
    MATCH_THREE(3, 5000, "3개 일치 (5,000원) - %d개"),
    MATCH_FOUR(4, 50000, "4개 일치 (50,000원) - %d개"),
    MATCH_FIVE(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    MATCH_FIVE_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_SIX(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");
    private final int matchCount;
    private final int prize;
    private final String message;

    LottoWinningTier (int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static LottoWinningTier getMatchCountTier (int matchCount, boolean isBonusNumber) {
        if (matchCount == MATCH_FIVE_COUNT && isBonusNumber) {
            return MATCH_FIVE_WITH_BONUS;
        }
        return Arrays.stream(LottoWinningTier.values())
                .filter(lottoWinningTier -> lottoWinningTier.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount () {
        return matchCount;
    }
    public int getPrize () {
        return prize;
    }
    public String getCountMessage(int winningCount) {
        return String.format(message, winningCount);
    }
}
