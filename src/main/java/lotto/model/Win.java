package lotto.model;

public enum Win {
    LOTTO_1ST(6),
    LOTTO_2ND(5),
    LOTTO_3RD(5),
    LOTTO_4TH(4),
    LOTTO_5TH(3)
    ;

    private final Integer containCount;

    private Win(Integer containCount) {
        this.containCount = containCount;
    }

    public static Win getWin(Integer containCount) {
        for(Win win : Win.values()) {
            if (win.containCount.equals(containCount)) {
                return win;
            }
        }
        return null;
    }
}
