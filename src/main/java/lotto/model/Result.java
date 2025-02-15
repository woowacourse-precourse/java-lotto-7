package lotto.model;

public enum Result {
    FIFTH(3, false, 5000, 0),
    FOURTH(4, false, 50000, 0),
    THIRD(5, false, 1500000, 0),
    SECOND(5, true, 30000000, 0),
    FIRST(6, false, 2000000000, 0);

    private final int matches;
    private final int money;
    private int count;
    private final boolean bonus;

    Result(int matches, boolean bonus, int money, int count) {
        this.matches = matches;
        this.bonus = bonus;
        this.money = money;
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public int getMatches() {
        return matches;
    }

    public boolean getBonus() {
        return bonus;
    }

    public String getStringBonus() {
        if (bonus) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }

}

