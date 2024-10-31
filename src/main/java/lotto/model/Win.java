package lotto.model;

public enum Win {
    LOTTO_1ST(6, 4),
    LOTTO_2ND(5, 3),
    LOTTO_3RD(5, 2),
    LOTTO_4TH(4, 1),
    LOTTO_5TH(3, 0)
    ;

    private final Integer containCount;
    private final Integer index;

    private Win(Integer containCount, Integer index) {
        this.containCount = containCount;
        this.index = index;
    }

    public static Win getWin(Integer containCount) {
        for(Win win : lotto.model.Win.values()) {
            if (win.containCount.equals(containCount)) {
                return win;
            }
        }
        return null;
    }

    public Integer getIndex() {
        return this.index;
    }
}
