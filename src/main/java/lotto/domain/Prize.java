package lotto.domain;

public enum Prize {

    FIFTH(3, false, 5_000, "5,000"),
    FOURTH(4, false, 50_000, "50,000"),
    THIRD(5, false, 1_500_000, "1,500,000"),
    SECOND(5, true, 30_000_000, "30,000,000"),
    FIRST(6, false, 2_000_000_000, "2,000,000,000"),
    MISS(0, false, 0, "0");

    private final int matchCount;
    private final boolean matchBonus;
    private final int prizeAmount;
    private final String prizeAmountString;

    Prize(int matchCount, boolean matchBonus, int prizeAmount, String prizeAmountString) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prizeAmount = prizeAmount;
        this.prizeAmountString = prizeAmountString;
    }

    public static Prize of(int matchCount, boolean matchBonus) {
        for (Prize prize : values()) {
            if(matchCount == 5 && matchBonus){
                return SECOND;
            }
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        return MISS;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String toDefaultString() {
        if(this. matchBonus) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + prizeAmountString + "원)";
        }
        return matchCount + "개 일치 (" + prizeAmountString + "원)";
    }

}
