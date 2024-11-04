package lotto.application.statistics.domain;

import static lotto.application.statistics.constants.Constants.FIFTH_MATCH_COUNT;
import static lotto.application.statistics.constants.Constants.FIFTH_PRIZE;
import static lotto.application.statistics.constants.Constants.FIRST_MATCH_COUNT;
import static lotto.application.statistics.constants.Constants.FIRST_PRIZE;
import static lotto.application.statistics.constants.Constants.FOURTH_MATCH_COUNT;
import static lotto.application.statistics.constants.Constants.FOURTH_PRIZE;
import static lotto.application.statistics.constants.Constants.MIN_WINNING_MATCH_COUNT;
import static lotto.application.statistics.constants.Constants.NO_PRIZE;
import static lotto.application.statistics.constants.Constants.SECOND_PRIZE;
import static lotto.application.statistics.constants.Constants.SECOND_THIRD_MATCH_COUNT;
import static lotto.application.statistics.constants.Constants.THIRD_PRIZE;
import static lotto.application.statistics.message.Message.FIFTH_RANK_DESC;
import static lotto.application.statistics.message.Message.FIRST_RANK_DESC;
import static lotto.application.statistics.message.Message.FOURTH_RANK_DESC;
import static lotto.application.statistics.message.Message.NO_PRIZE_DESC;
import static lotto.application.statistics.message.Message.RESULT_FORMAT;
import static lotto.application.statistics.message.Message.SECOND_RANK_DESC;
import static lotto.application.statistics.message.Message.THIRD_RANK_DESC;

import java.util.stream.Stream;

public enum Rank {
    FIRST(FIRST_MATCH_COUNT, FIRST_PRIZE, FIRST_RANK_DESC) {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == FIRST_MATCH_COUNT;
        }
    },
    SECOND(SECOND_THIRD_MATCH_COUNT, SECOND_PRIZE, SECOND_RANK_DESC) {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == SECOND_THIRD_MATCH_COUNT && matchBonus;
        }
    },
    THIRD(SECOND_THIRD_MATCH_COUNT, THIRD_PRIZE, THIRD_RANK_DESC) {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == SECOND_THIRD_MATCH_COUNT && !matchBonus;
        }
    },
    FOURTH(FOURTH_MATCH_COUNT, FOURTH_PRIZE, FOURTH_RANK_DESC) {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == FOURTH_MATCH_COUNT;
        }
    },
    FIFTH(FIFTH_MATCH_COUNT, FIFTH_PRIZE, FIFTH_RANK_DESC) {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount == FIFTH_MATCH_COUNT;
        }
    },
    NONE(NO_PRIZE, NO_PRIZE, NO_PRIZE_DESC) {
        @Override
        public boolean matches(int matchCount, boolean matchBonus) {
            return matchCount < MIN_WINNING_MATCH_COUNT;
        }
    };

    private final int matchCount;
    private final int prize;
    private final String description;

    Rank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public abstract boolean matches(int matchCount, boolean matchBonus);

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return findMatchedRank(matchCount, matchBonus);
    }

    public int getPrize() {
        return prize;
    }

    public String toFormattedString(long count) {
        return String.format(RESULT_FORMAT, description, prize, count);
    }

    private static Rank findMatchedRank(int matchCount, boolean matchBonus) {
        return Stream.of(values())
                .filter(rank -> rank.matches(matchCount, matchBonus))
                .findFirst()
                .orElse(NONE);
    }

}
