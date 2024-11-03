package lotto.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank implements RankProvider {

    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)") {
        @Override
        public String notation(WinningResult result) {
            Integer count = result.getWinningCount(this);
            return String.format(RANK_RESULT_NOTATION_FORM, this.getMessage(), count);
        }

        @Override
        public Long totalPrize(WinningResult result) {
            return result.getWinningCount(this) * this.getPrize();
        }
    },
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)") {
        @Override
        public String notation(WinningResult result) {
            Integer count = result.getWinningCount(this);
            return String.format(RANK_RESULT_NOTATION_FORM, this.getMessage(), count);
        }

        @Override
        public Long totalPrize(WinningResult result) {
            return result.getWinningCount(this) * this.getPrize();
        }
    },
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)") {
        @Override
        public String notation(WinningResult result) {
            Integer count = result.getWinningCount(this);
            return String.format(RANK_RESULT_NOTATION_FORM, this.getMessage(), count);
        }

        @Override
        public Long totalPrize(WinningResult result) {
            return result.getWinningCount(this) * this.getPrize();
        }
    },
    FOURTH(4, 50_000, "4개 일치 (50,000원)") {
        @Override
        public String notation(WinningResult result) {
            Integer count = result.getWinningCount(this);
            return String.format(RANK_RESULT_NOTATION_FORM, this.getMessage(), count);
        }

        @Override
        public Long totalPrize(WinningResult result) {
            return result.getWinningCount(this) * this.getPrize();
        }

    },
    FIFTH(3, 5_000, "3개 일치 (5,000원)") {
        @Override
        public String notation(WinningResult result) {
            Integer count = result.getWinningCount(this);
            return String.format(RANK_RESULT_NOTATION_FORM, this.getMessage(), count);
        }

        @Override
        public Long totalPrize(WinningResult result) {
            return result.getWinningCount(this) * this.getPrize();
        }

    },
    NONE(0, 0, "당첨되지 않았음 (0원)") {
        @Override
        public String notation(WinningResult result) {
            Integer count = result.getWinningCount(this);
            return String.format(RANK_RESULT_NOTATION_FORM, this.getMessage(), count);
        }

        @Override
        public Long totalPrize(WinningResult result) {
            return result.getWinningCount(this) * this.getPrize();
        }
    };

    public static final String RANK_RESULT_NOTATION_FORM = "%s - %d개%n";

    private final int matchCount;
    private final long prize;
    private final String message;

    Rank(int matchCount, long prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static Rank of(int matchCount, boolean isMatchBonusNumber) {
        if (FIRST.matchCount == matchCount) {
            return FIRST;
        }
        if (SECOND.matchCount == matchCount && isMatchBonusNumber) {
            return SECOND;
        }
        if (THIRD.matchCount == matchCount) {
            return THIRD;
        }
        if (FOURTH.matchCount == matchCount) {
            return FOURTH;
        }
        if (FIFTH.matchCount == matchCount) {
            return FIFTH;
        }
        return NONE;
    }

    public static String notationFrom(WinningResult result) {
        return Arrays.stream(values())
            .filter(rank -> rank != NONE)
            .map(rank -> rank.notation(result))
            .collect(Collectors.joining());
    }

    public long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
