package lotto.model.enums;

public enum Rank {
    FIRST("6개 일치", 6),
    SECOND("5개 일치, 보너스 볼 일치", 5),
    THIRD("5개 일치", 5),
    FOURTH("4개 일치", 4),
    FIFTH("3개 일치", 3),
    NONE("꽝", 0)
    ;

    private final String message;
    private final Integer match;

    Rank(String message, int match) {
        this.message = message;
        this.match = match;
    }

    public String getMessage() {
        return message;
    }

    public static Rank checkRank(long match, boolean bonus) {
        if (match == FIRST.match) {
            return FIRST;
        }
        if (match == SECOND.match) {
            if (bonus) {
                return SECOND;
            }
            return THIRD;
        }
        if (match == FOURTH.match) {
            return FOURTH;
        }
        if (match == FIFTH.match) {
            return FIFTH;
        }
        return NONE;
    }
}
