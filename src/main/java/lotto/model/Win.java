package lotto.model;

public enum Win {
    LOTTO_1ST(6, 4, 2000000000),
    LOTTO_2ND(5, 3, 30000000),
    LOTTO_3RD(5, 2, 1500000),
    LOTTO_4TH(4, 1, 50000),
    LOTTO_5TH(3, 0, 5000)
    ;

    private final Integer containCount;
    private final Integer index;
    private final Integer winnings;

    private Win(Integer containCount, Integer index, Integer winnings) {
        this.containCount = containCount;
        this.index = index;
        this.winnings = winnings;
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

    public Integer getWinnings() {
        return this.winnings;
    }
}
