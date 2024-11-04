package lotto;

import java.util.Arrays;

public enum LottoPlaceDecider implements LottoPlaceDecidable {
    FIRST(6, false) {
        @Override
        public LottoPlace decide() {
            return LottoPlace.FIRST;
        }
    },
    SECOND(5, true) {
        @Override
        public LottoPlace decide() {
            return LottoPlace.SECOND;
        }
    },
    THIRD(5, false) {
        @Override
        public LottoPlace decide() {
            return LottoPlace.THIRD;
        }
    },
    FORTH(4, false) {
        @Override
        public LottoPlace decide() {
            return LottoPlace.FORTH;
        }
    },
    FIFTH(3, false) {
        @Override
        public LottoPlace decide() {
            return LottoPlace.FIFTH;
        }
    },
    LOSE(2, false) {
        @Override
        public LottoPlace decide() {
            return LottoPlace.LOSE;
        }

        @Override
        public boolean supports(int matchingCount, boolean hasBonusNumber) {
            return matchingCount <= getMatchingCount();
        }
    };

    private final int matchingCount;
    private final boolean hasBonusNumber;

    LottoPlaceDecider(int matchingCount, boolean hasBonusNumber) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    @Override
    public boolean supports(int matchingCount, boolean hasBonusNumber) {
        return this.matchingCount == matchingCount && this.hasBonusNumber == hasBonusNumber;
    }

    public static LottoPlace findLottoPlaceBy(int matchingCount, boolean hasBonusNumber) {
        return findAppropriateDecider(matchingCount, hasBonusNumber).decide();
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    private static LottoPlaceDecider findAppropriateDecider(int matchingCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(decider -> decider.supports(matchingCount, hasBonusNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 등수를 확인할 수 없습니다."));
    }

}
