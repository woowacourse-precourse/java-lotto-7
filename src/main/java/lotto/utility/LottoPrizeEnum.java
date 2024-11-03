package lotto.utility;

public enum LottoPrizeEnum {
    THREE_MATCHED("3개 일치 (5,000원)"),
    FOUR_MATCHED("4개 일치 (50,000원)"),
    FIVE_MATCHED("5개 일치 (1,500,000원)"),
    FIVE_WITH_BONUS_MATCHED("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHED("6개 일치 (2,000,000,000원)");

    private final String message;

    LottoPrizeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}