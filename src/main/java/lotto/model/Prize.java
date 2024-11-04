package lotto.model;

public enum Prize {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    NO_PRIZE(0, 0, "0개 일치 (0원)")
    ;

    Integer matchCount;
    Integer money;
    String message;

    Prize(Integer matchCount, Integer money, String message) {
        this.matchCount = matchCount;
        this.money = money;
        this.message = message;
    }

    public static Prize getResult(Integer matchCount, boolean bonus) {
        if(matchCount == FIRST.matchCount) {
            return FIRST;
        } else if(matchCount == SECOND.matchCount && bonus) {
            return SECOND;
        } else if(matchCount == THIRD.matchCount) {
            return THIRD;
        } else if(matchCount == FOURTH.matchCount) {
            return FOURTH;
        } else if(matchCount == FIFTH.matchCount) {
            return FIFTH;
        }

        return NO_PRIZE;
    }
}
