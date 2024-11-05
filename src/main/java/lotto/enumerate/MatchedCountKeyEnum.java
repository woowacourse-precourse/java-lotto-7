package lotto.enumerate;

public enum MatchedCountKeyEnum {
    THREE_MATCHED("threeMatched"),
    FOUR_MATCHED("fourMatched"),
    FIVE_MATCHED("fiveMatched"),
    FIVE_WITH_BONUS_MATCHED("fiveWithBonusMatched"),
    SIX_MATCHED("sixMatched");

    private final String key;

    MatchedCountKeyEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}