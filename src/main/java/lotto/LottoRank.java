package lotto;

public enum LottoRank {

    FIRST("1등", 6, false, 2000000000, 5),
    SECOND("2등", 5, true, 30000000, 4),
    THIRD("3등", 5, false, 1500000, 3),
    FOURTH("4등", 4, false, 50000,  2),
    FIFTH("5등", 3, false, 5000, 1),
    NONE("꽝", 0, false, 0, null);

    private final String name;
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private final Integer printOrder;

    LottoRank(String name, int matchCount, boolean matchBonus, int prize, Integer printOrder) {
        this.name = name;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
        this.printOrder = printOrder;
    }

    public String getName() {
        return name;
    }

    public int getMatchCount() { return matchCount; }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrize() { return prize; }

    public Integer getPrintOrder() {
        return printOrder;
    }

}
