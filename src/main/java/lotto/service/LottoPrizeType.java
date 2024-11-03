package lotto.service;

public enum LottoPrizeType {
    THREE_MATCH(5000L),
    FOUR_MATCH(50000L),
    FIVE_MATCH(1500000L),
    FIVE_MATCH_WITH_BONUS(30000000L),
    SIX_MATCH(2000000000L),
    NO_MATCH(0L);

    private final Long type;

    LottoPrizeType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }
}
