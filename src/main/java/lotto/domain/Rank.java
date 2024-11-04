package lotto.domain;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public enum Rank {

    FIRST(6, false, 2_000_000_000), // 1등
    SECOND(5, true, 30_000_000),    // 2등
    THIRD(5, false, 1_500_000),     // 3등
    FOURTH(4, false, 50_000),       // 4등
    FIFTH(3, false, 5_000),         // 5등
    MISS(0, false, 0),              // 꽝
    ;

    private final int matchCount;
    private final boolean hasBonus;
    private final int winningAmount;

    Rank(int matchCount, boolean hasBonus, int winningAmount) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.winningAmount = winningAmount;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus) {
        // 2등인 경우에만 보너스 볼을 고려함
        if (matchCount == SECOND.matchCount && hasBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank != SECOND)
                .findFirst()
                .orElse(MISS);
    }

    public static List<Rank> getDescendingRanks() {
        return Arrays.stream(values())
                .filter(rank -> rank != MISS)
                .sorted(Comparator.comparingInt(Rank::getWinningAmount))
                .toList();
    }

    public String getFormattedResult() {
        if (this == MISS) {
            return "";
        }

        // 당첨금을 한국 통화 형식으로 변환 (eg. 1,000,000)
        NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        String formattedAmount = currencyFormat.format(winningAmount);

        if (this == SECOND) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + formattedAmount + "원)";
        }
        return matchCount + "개 일치 (" + formattedAmount + "원)";
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
