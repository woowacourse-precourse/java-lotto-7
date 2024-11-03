package lotto;

public enum LottoResult {
    NO_MATCH,
    THREE_MATCH,
    FOUR_MATCH,
    FIVE_MATCH,
    FIVE_MATCH_BONUS,
    SIX_MATCH;

    public static LottoResult getLottoResult(int count, boolean isBonusMatched) {
        if (count == 6) {
            return SIX_MATCH;
        }

        if (count == 5 && isBonusMatched) {
            return FIVE_MATCH_BONUS;
        }

        if (count == 5) {
            return FIVE_MATCH;
        }

        if (count == 4) {
            return FOUR_MATCH;
        }

        if (count == 3) {
            return THREE_MATCH;
        }

        return NO_MATCH;
    }
}
