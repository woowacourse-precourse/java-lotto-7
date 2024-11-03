package lotto;

import java.util.Arrays;

public enum MatchResult {
    NO_MATCH(0, false) {
        @Override
        public void win(WinningStatics statics) {
        }
    },
    FIFTH_PLACE(3, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winFifth();
        }
    },
    FOURTH_PLACE(4, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winFourth();
        }
    },
    THIRD_PLACE(5, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winThird();
        }
    },
    SECOND_PLACE(5, true) {
        @Override
        public void win(WinningStatics statics) {
            statics.winSecond();
        }
    },
    FIRST_PLACE(6, false) {
        @Override
        public void win(WinningStatics statics) {
            statics.winFirst();
        }
    };

    public abstract void win(WinningStatics statics);

    private final int match;

    MatchResult(int match, boolean bonus) {
        this.match = match;
    }

    public static MatchResult valueOf(int match, boolean bonus) {
        if (match == 5) {
            return bonus ? SECOND_PLACE : THIRD_PLACE;
        }
        return Arrays.stream(values())
                .filter(result -> result.match == match)
                .findFirst()
                .orElse(NO_MATCH);
    }
}
