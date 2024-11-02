package lotto.core.enums;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum WinningRank {

    RANK_1(1, 6, false, BigDecimal.valueOf(2_000_000_000L)),
    RANK_2(2, 5, true, BigDecimal.valueOf(30_000_000L)),
    RANK_3(3, 5, false, BigDecimal.valueOf(1_500_000L)),
    RANK_4(4, 4, false, BigDecimal.valueOf(50_000L)),
    RANK_5(5, 3, false, BigDecimal.valueOf(5_000L));

    private final int rank;
    private final int matchCount;
    private final boolean isBonus;
    private final BigDecimal winningAmount;

    WinningRank(int rank, int matchCount, boolean isBonus, BigDecimal winningAmount) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.winningAmount = winningAmount;
    }

    public int getRank() {
        return this.rank;
    }

    public boolean isBonus() {
        return this.isBonus;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public BigDecimal getWinningAmount() {
        return this.winningAmount;
    }

    public static WinningRank match(int matchCount, boolean matchBonus) {
        if (matchBonus) {
            WinningRank bonusRank = findBonusRank(matchCount);
            if (bonusRank != null) {
                return bonusRank;
            }
        }

        WinningRank[] notBonusRank = filterRank(it -> !it.isBonus);
        return findMatchRank(notBonusRank, matchCount);
    }

    private static WinningRank findBonusRank(int matchCount) {
        WinningRank[] bonusRank = filterRank(it -> it.isBonus);
        return findMatchRank(bonusRank, matchCount);
    }

    private static WinningRank[] filterRank(Predicate<WinningRank> predicate) {
        return Arrays.stream(WinningRank.values())
                .filter(predicate)
                .toArray(WinningRank[]::new);
    }

    private static WinningRank find(WinningRank[] ranks, Predicate<WinningRank> predicate) {
        return findFirst(ranks, predicate);
    }

    private static WinningRank findFirst(WinningRank[] ranks, Predicate<WinningRank> predicate) {
        for (WinningRank rank : ranks) {
            if (predicate.test(rank)) {
                return rank;
            }
        }
        return null;
    }

    private static WinningRank findMatchRank(WinningRank[] ranks, int matchCount) {
        return findFirst(ranks, it -> it.getMatchCount() == matchCount);
    }

    public static List<WinningRank> sortedListByRankDescending() {
        return Arrays.stream(WinningRank.values())
                .sorted((a, b) -> b.getRank() - a.getRank())
                .toList();
    }

    public String formatDisplay() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        StringBuilder builder = new StringBuilder();
        builder.append(this.matchCount);
        builder.append("개 일치");
        if (this.isBonus) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append(" (");
        builder.append(decimalFormat.format(this.winningAmount));
        builder.append("원)");
        return builder.toString();
    }
}
