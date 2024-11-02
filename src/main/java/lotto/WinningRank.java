package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum WinningRank {

    FIFTH(3, 5_000) {
        @Override
        int calculateRevenue() {
            return FIFTH.reward * FIFTH.successMatch;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        int calculateRevenue() {
            return FOURTH.reward * FOURTH.successMatch;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        int calculateRevenue() {
            return THIRD.reward * THIRD.successMatch;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        int calculateRevenue() {
            return SECOND.reward * SECOND.successMatch;
        }
    },
    FIRST(6, 2_000_000_000) {
        @Override
        int calculateRevenue() {
            return FIRST.reward * FIRST.successMatch;
        }
    },
    NONE(0, 0) {
        @Override
        int calculateRevenue() {
            return 0;
        }
    };

    private static final DecimalFormat WINNING_AMOUNT_FORMAT = new DecimalFormat("#,###");
    private static final String BONUS_STATISTICS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String BASIC_STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개";

    private final int requiredMatch;
    private final int reward;
    private int successMatch;

    WinningRank(int requiredMatch, int reward) {
        this.requiredMatch = requiredMatch;
        this.reward = reward;
        this.successMatch = 0;
    }

    abstract int calculateRevenue();

    public int getSuccessMatch() {
        return successMatch;
    }

    public void resetSuccessMatch() {
        successMatch = 0;
    }

    public static WinningRank match(int requiredMatch, boolean hasBonus) {
        if (isMatchSecond(requiredMatch, hasBonus)) {
            increase(WinningRank.SECOND);
            return WinningRank.SECOND;
        }

        return getWinningRank(requiredMatch);
    }

    private static boolean isMatchSecond(int requiredMatch, boolean hasBonus) {
        return requiredMatch == 5 && hasBonus;
    }

    private static WinningRank getWinningRank(int requiredMatch) {
        Optional<WinningRank> winningRank = Arrays.stream(WinningRank.values())
                .filter(rank -> rank != SECOND)
                .filter(rank -> rank.requiredMatch == requiredMatch)
                .findFirst();

        if (winningRank.isEmpty()) {
            return NONE;
        }

        increase(winningRank.get());

        return winningRank.get();
    }

    private static void increase(WinningRank rank) {
        rank.successMatch++;
    }

    public static String winningStatus() {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank != NONE)
                .map(WinningRank::selectStatus)
                .collect(Collectors.joining("\n"));
    }

    private static String selectStatus(WinningRank rank) {
        String reward = formattingReward(rank);

        if (isSecond(rank)) {
            return secondStatistics(rank, reward);
        }
        return statistics(rank, reward);
    }

    private static String formattingReward(WinningRank rank) {
        return WINNING_AMOUNT_FORMAT.format(rank.reward);
    }

    private static boolean isSecond(WinningRank rank) {
        return rank == WinningRank.SECOND;
    }

    private static String secondStatistics(WinningRank rank, String reward) {
        return String.format(BONUS_STATISTICS_FORMAT, rank.requiredMatch, reward, rank.successMatch);
    }

    private static String statistics(WinningRank rank, String reward) {
        return String.format(BASIC_STATISTICS_FORMAT, rank.requiredMatch, reward, rank.successMatch);
    }
}
