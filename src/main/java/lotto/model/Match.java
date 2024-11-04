package lotto.model;

public enum Match {
    MATCH3(3, 5000, false),
    MATCH4(4, 50000, false),
    MATCH5(5, 1500000, false),
    MATCH5_BONUS(5, 30000000, true),
    MATCH6(6, 2000000000, false);


    private Integer matchCount;
    private Integer money;
    private boolean bonusMatch;

    Match(Integer matchCount, Integer money, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.money = money;
        this.bonusMatch = bonusMatch;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getMoney() {
        return money;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static Match findMatch(Integer matchCount, boolean bonusMatch) {
        for (Match match : Match.values()) {
            if (match.getMatchCount().equals(matchCount) && match.isBonusMatch() == bonusMatch)
                return match;
        }
        return null;
    }
}
