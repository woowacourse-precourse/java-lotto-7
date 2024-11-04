package lotto;

public enum Prise {
    FIFTH(3, "(5,000원)"),
    FORTH(4, "(50,000원)"),
    THIRD(5, "(1,500,000원)"),
    SECOND(5, "(30,000,000원)"),
    FIRST(6, "(2,000,000,000원)");

    private final int match;
    private final String money;

    Prise(int match, String money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public String getMoney() {
        return money;
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
