package lotto.model;

import java.util.Map;

public class Money {

    public static final int LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTicketCount() {
        return money / LOTTO_PRICE;
    }

    public String getRateOfReturn(Map<Rank, Integer> result) {
        double income = 0;
        for (Rank rank : result.keySet()) {
            income += rank.getPrice() * result.get(rank);
        }
        return String.format("%.1f" ,(income / money) * 100);
    }
}
