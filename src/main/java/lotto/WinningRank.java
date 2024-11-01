package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
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

    public int getSuccessMatch() {
        return successMatch;
    }

    public void resetSuccessMatch() {
        successMatch = 0;
    }

    public static WinningRank of(int requiredMatch, boolean hasBonus) {
        if (requiredMatch == 5 && hasBonus) {
            increase(WinningRank.SECOND);
            return WinningRank.SECOND;
        }

        WinningRank lottoRank = Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.SECOND)
                .filter(rank -> rank.requiredMatch == requiredMatch)
                .findFirst()
                .orElseThrow();

        increase(lottoRank);

        return lottoRank;
    }

    private static void increase(WinningRank rank) {
        rank.successMatch++;
    }

    abstract int calculateRevenue();

    public static String winningStatus() {
        return Arrays.stream(WinningRank.values())
                .map(rank -> {
                    String reward = WINNING_AMOUNT_FORMAT.format(rank.reward);

                    if (rank == WinningRank.SECOND) {
                        return String.format(BONUS_STATISTICS_FORMAT, rank.requiredMatch, reward, rank.successMatch);
                    }
                    return String.format(BASIC_STATISTICS_FORMAT, rank.requiredMatch, reward, rank.successMatch);
                })
                .collect(Collectors.joining("\n"));
    }
}
