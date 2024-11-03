package lotto.enums;

public enum Win {
    LOTTO_1ST(0, 6, false, 2000000000),
    LOTTO_2ND(1, 5, true, 30000000),
    LOTTO_3RD(2, 5, false, 1500000),
    LOTTO_4TH(3, 4, false, 50000),
    LOTTO_5TH(4, 3, false, 5000);

    private final Integer rank;
    private final Integer containCount;
    private final Boolean containBonus;
    private final Integer winnings;

    private Win(Integer rank, Integer containCount, Boolean containBonus, Integer winnings) {
        this.rank = rank;
        this.containCount = containCount;
        this.containBonus = containBonus;
        this.winnings = winnings;
    }

    public static Win getWin(Integer containCount, Boolean containBonus) {
        for (Win win : Win.values()) {
            if (win.containCount.equals(containCount) && win.containBonus.equals(containBonus)) {
                return win;
            }
        }
        return null;
    }

    public Integer getRank() {
        return this.rank;
    }

    public Integer getWinnings() {
        return this.winnings;
    }
}
