package lotto.utility;

public enum MatchedCountNameEnum {
    THREE_MATCHED("threeMatched"),
    FOUR_MATCHED("fourMatched"),
    FIVE_MATCHED("fiveMatched"),
    FIVE_WITH_BONUS_MATCHED("fiveWithBonusMatched"),
    SIX_MATCHED("sixMatched");

    private final String message;

    MatchedCountNameEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}