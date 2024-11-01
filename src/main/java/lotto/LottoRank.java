package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum LottoRank {

    FIFTH(3, 5_000) {
        @Override
        int calculateRevenue() {
            return FIFTH.reward * FIFTH.match;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        int calculateRevenue() {
            return FOURTH.reward * FOURTH.match;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        int calculateRevenue() {
            return THIRD.reward * THIRD.match;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        int calculateRevenue() {
            return SECOND.reward * SECOND.match;
        }
    },
    FIRST(6, 2_000_000_000) {
        @Override
        int calculateRevenue() {
            return FIRST.reward * FIRST.match;
        }
    };

    private static final DecimalFormat WINNING_AMOUNT_FORMAT = new DecimalFormat("#,###");
    private static final String BONUS_STATISTICS_FORMAT = "%d개 일치, 보너스 번호 일치 (%s원) - %d개";
    private static final String BASIC_STATISTICS_FORMAT = "%d개 일치 (%s원) - %d개";

    private final int matchCount;
    private final int reward;
    private int match;

    LottoRank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.match = 0;
    }

    public int getMatch() {
        return match;
    }

    public void resetMatch() {
        match = 0;
    }

    public static LottoRank matchRank(int matchCount, boolean isMatchedBonus) {
        if (matchCount == 5 && isMatchedBonus) {
            increaseMatch(LottoRank.SECOND);
            return LottoRank.SECOND;
        }

        LottoRank rank = Arrays.stream(LottoRank.values())
                .filter(value -> value != LottoRank.SECOND)
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElseThrow();

        increaseMatch(rank);

        return rank;
    }

    private static void increaseMatch(LottoRank rank) {
        rank.match++;
    }

    abstract int calculateRevenue();

    public static String winningStatus() {
        return Arrays.stream(LottoRank.values())
                .map(rank -> {
                    String reward = WINNING_AMOUNT_FORMAT.format(rank.reward);

                    if (rank == LottoRank.SECOND) {
                        return String.format(BONUS_STATISTICS_FORMAT, rank.matchCount, reward, rank.match);
                    }
                    return String.format(BASIC_STATISTICS_FORMAT, rank.matchCount, reward, rank.match);
                })
                .collect(Collectors.joining("\n"));
    }
}
