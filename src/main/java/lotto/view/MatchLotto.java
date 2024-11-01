package lotto.view;

public enum MatchLotto {
    MATCH_THREE(3, 0),
    MATCH_FOUR(4, 1),
    MATCH_FIVE(5, 2),
    MATCH_BONUS_FIVE(5, 3),
    MATCH_SIX(6, 4);

    private final int matchCount;
    private final int index;

    MatchLotto(int matchCount, int index) {
        this.matchCount = matchCount;
        this.index = index;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getIndex() {
        return index;
    }

    public static MatchLotto getResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return MATCH_BONUS_FIVE;
        }

        for (MatchLotto result : values()) {
            if (result.getMatchCount() == matchCount) {
                return result;
            }
        }
        return null;
    }
}

