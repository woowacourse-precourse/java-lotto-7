package lotto.service;

public enum LottoWinType {
    THREE_MATCH(0),
    FOUR_MATCH(1),
    FIVE_MATCH(2),
    FIVE_MATCH_WITH_BONUS(3),
    SIX_MATCH(4),
    NO_MATCH(5);

    private final Integer type;

    LottoWinType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
