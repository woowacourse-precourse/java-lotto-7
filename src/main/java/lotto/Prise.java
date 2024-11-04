package lotto;

public enum Prise {
    FIFTH(3, 5000, "(5,000원)"),
    FORTH(4, 50000, "(50,000원)"),
    THIRD(5, 1500000, "(1,500,000원)"),
    SECOND(5, 30000000, "(30,000,000원)"),
    FIRST(6, 2000000000, "(2,000,000,000원)");

    private final int match;
    private final int money;
    private final String moneyString;

    Prise(int match, int money, String moneyString) {
        this.match = match;
        this.money = money;
        this.moneyString = moneyString;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public String getMoneyString() {
        return moneyString;
    }

    public static Prise getRank(int match) {
        for (Prise p : Prise.values()) {
            if (p.getMatch() == match) {
                return p;
            }
        }
        return null;
    }
}
