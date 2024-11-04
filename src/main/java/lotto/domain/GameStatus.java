package lotto.domain;

public enum GameStatus {

    START_NUMBER(1L),
    END_NUMBER(45L),
    TOTAL_BALL_COUNT(6L),
    LOWEST_GAME_COUNT(0L),
    ADDED_GAME_COUNT(1L);

    private final Long value;

    GameStatus(Long value) {
        this.value = value;
    }

    public Long get() {
        return value;
    }

    public Integer getInt() {
        return value.intValue();
    }
}