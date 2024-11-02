package lotto;

public enum Result {
    FIRST(2000000000, 0, 6, false),
    SECOND(30000000, 0, 5, true),
    THIRD(1500000, 0, 5, false),
    FOURTH(50000, 0, 4, false),
    FIFTH(5000, 0, 3, false);

    private final double money;
    private int count;
    private final int matches;
    private final boolean bonus;

    Result(int money, int count, int matches, boolean bonus) {
        this.money = money;
        this.count = count;
        this.matches = matches;
        this.bonus = bonus;
    }

    public double getMoney() {
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
}

