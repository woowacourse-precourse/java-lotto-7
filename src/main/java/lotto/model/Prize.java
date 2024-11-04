package lotto.model;

public enum Prize {
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    SIXTH(0, false, 0, "꽝");

    private final Integer winningCount;
    private final boolean isBonusNumberMatch;
    private final Integer reward;
    private final String text;

    Prize(Integer winningCount, boolean isBonusNumberMatch, Integer reward, String text) {
        this.winningCount = winningCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.reward = reward;
        this.text = text;
    }

    public static Prize calculatePrize(Integer winningCount, boolean isBonusNumberMatch) {
        for(Prize prize : Prize.values()) {
            if(prize.winningCount == winningCount && prize.isBonusNumberMatch == isBonusNumberMatch) {
                return prize;
            }
        }
        return Prize.SIXTH;
    }

    public String formatDescription(Prize prize, Integer count) {
        return prize.text + String.format(" - %d개\n", count);
    }

    public void sumReward(Yield yield, Integer count) {
        yield.addReward(reward * count);
    }
}