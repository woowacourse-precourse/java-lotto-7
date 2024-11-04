package lotto.service.input.validator;

public enum ValidateStatus {

    MINIMAL_NUMBER(1),
    MAXIMUM_NUMBER(45),

    TOTAL_BALL_COUNT(6),
    TOTAL_SEPARATOR_COUNT(5),

    LOWEST_GAME_COUNT(0);

    private final Integer value;

    ValidateStatus(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}