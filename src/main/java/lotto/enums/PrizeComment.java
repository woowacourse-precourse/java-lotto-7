package lotto.enums;

public enum PrizeComment {
    SAME_THREE("3개 일치 (5,000원) - "),
    SAME_FOUR("4개 일치 (50,000원) - "),
    SAME_FIVE("5개 일치 (1,500,000원) - "),
    SAME_FIVE_PLUS_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SAME_SIX("6개 일치 (2,000,000,000원) - ");

    private final String message;

    PrizeComment(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
