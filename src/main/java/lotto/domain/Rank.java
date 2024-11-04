package lotto.domain;

public enum Rank {
    FIRST("1등",6,false, 2_000_000_000,"6개 일치 (2,000,000,000원) - %d개" ),
    SECOND("2등",5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD("3등",5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH("4등",4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH("5등",3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    NO_RANK("꽝",0, false, 0, "꽝 (0원)");

    private final String name;
    private final int machCount;
    private final boolean isMatchBonus;
    private final int prizeMoney;
    private final String viewMessage;
    Rank(String name, int machCount, boolean isMatchBonus ,int prizeMoney, String viewMessage) {
        this.name = name;
        this.machCount = machCount;
        this.isMatchBonus = isMatchBonus;
        this.prizeMoney = prizeMoney;
        this.viewMessage = viewMessage;
    }

    public String getName() {
        return name;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String format(int count) {
        return String.format(this.viewMessage, count);
    }
}
