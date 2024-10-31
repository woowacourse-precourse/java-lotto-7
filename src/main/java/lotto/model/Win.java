package lotto.model;

public enum Win {
    LOTTO_1ST(6, false, 4, 2000000000),
    LOTTO_2ND(5, true, 3, 30000000),
    LOTTO_3RD(5, false, 2, 1500000),
    LOTTO_4TH(4, false, 1, 50000),
    LOTTO_5TH(3, false, 0, 5000)
    ;

    private final Integer containCount;
    private final Boolean containBonus;
    private final Integer index;
    private final Integer winnings;

    private Win(Integer containCount, Boolean containBonus, Integer index, Integer winnings) {
        this.containCount = containCount;
        this.containBonus = containBonus;
        this.index = index;
        this.winnings = winnings;
    }

    public static Win getWin(Integer containCount, Boolean containBonus) {
        for(Win win : lotto.model.Win.values()) {
            if (win.containCount.equals(containCount) && win.containBonus.equals(containBonus)) {
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
