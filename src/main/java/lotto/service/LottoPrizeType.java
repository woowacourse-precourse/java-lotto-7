package lotto.service;

public enum LottoPrizeType {
    THREE_MATCH(5_000L),
    FOUR_MATCH(50_000L),
    FIVE_MATCH(1_500_000L),
    FIVE_MATCH_WITH_BONUS(30_000_000L),
    SIX_MATCH(2_000_000_000L),
    NO_MATCH(0L);

    private final Long type;

    LottoPrizeType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }
}
