package lotto.service.constant.prize;

public enum PrizeConditionImpl implements PrizeCondition {

    FIFTH_PRIZE(3L,  5_000L),
    FORTH_PRIZE(4L, 50_000L),

    SECOND_OR_THREE_PRIZE(5L,  0L),

    THIRD_PRIZE(5L, 1_500_000L),
    SECOND_PRIZE(5L, 30_000_000L),

    FIRST_PRIZE(6L,  2_000_000_000L);

    private final Long correctNumber;
    private final Long prizeMoney;

    PrizeConditionImpl(Long correctNumber, Long prizeMoney) {
        this.correctNumber = correctNumber;
        this.prizeMoney = prizeMoney;
    }

    @Override
    public Long getCorrectNumber() {
        return correctNumber;
    }

    @Override
    public Long getPrizeMoney() {
        return prizeMoney;
    }
}