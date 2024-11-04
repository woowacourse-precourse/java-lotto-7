package lotto;

public enum Prise {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000),
    SIXTH(2, 0);

    private final int match;
    private final int money;

    Prise(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public static Prise getRank(int match) {
        for (Prise p : Prise.values()) {
            if (p.getMatch() == match) {
                return p;
            }
        }
        return SIXTH;
    }
}
