package enums;

import java.text.DecimalFormat;

public enum Prize {
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", (int) 3e7),
    FIRST("6개 일치", (int) 2e9);

    private final String description;
    private final int money;

    Prize(String description, int money) {
        this.description = description;
        this.money = money;
    }

    public String getDescription() {
        DecimalFormat df = new DecimalFormat("#,###");
        String moneyFormat = df.format(money);

        return description + " (" + moneyFormat + "원) - ";
    }

    public int getMoney() {
        return money;
    }

}
