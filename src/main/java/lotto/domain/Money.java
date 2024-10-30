package lotto.domain;

import java.util.Map;
import lotto.constant.LottoConst;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTicketCount() {
        return money / LottoConst.LOTTO_PRICE;
    }

    public String getRateOfReturn(Map<Rank, Integer> result) {
        double income = 0;
        for (Rank rank : result.keySet()) {
            income += rank.getPrice() * result.get(rank);
        }
        return String.format("%.1f" ,(income / money) * LottoConst.PERCENTAGE);
    }
}
