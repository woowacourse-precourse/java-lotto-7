package lotto.domain;

import java.util.Arrays;
import lotto.enums.LottoValue;

public enum Rank {
    FAIL("", 0, 0),
    THREE_MATCHES("3개 일치 (5,000원) - %d개\n", 3, 5_000),
    FOUR_MATCHES("4개 일치 (50,000원) - %d개\n", 4, 50_000),
    FIVE_MATCHES("5개 일치 (1,500,000원) - %d개\n", 5, 1_500_000),
    FIVE_MATCHES_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 5, 3_000_000),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개\n", 6, 2_000_000_000);

    private final String lotteryStatistics;
    private final int matchingCount;
    private final int prize;

    Rank(String lotteryStatistics, int matchingCount, int prize) {
        this.lotteryStatistics = lotteryStatistics;
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank findMatchesRankCount(WinningNumber winningNumber, BonusNumber bonusNumber, Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningNumber);
        boolean matchBonus = lotto.isMatchBonus(bonusNumber);
        if (isFiveMatchesAndBonus(matchCount, matchBonus)) {
            return FIVE_MATCHES_AND_BONUS;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingCount == matchCount)
                .findAny()
                .orElse(FAIL);
    }

    private static boolean isFiveMatchesAndBonus(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return true;
        }
        return false;
    }

    public String getLotteryStatistics() {
        return lotteryStatistics;
    }

    public int getPrize() {
        return prize;
    }
}
