package lotto.purchase.domain;

import lotto.common.util.IdHolder;

public class Purchase {

    private final String id;
    private final String lottoResultId;
    private final Money money;

    private Purchase(String id, String lottoResultId, Money money) {
        this.id = id;
        this.lottoResultId = lottoResultId;
        this.money = money;
    }

    public static Purchase of(String lottoResultId, Money money) {
        return new Purchase(IdHolder.generateID(), lottoResultId, money);
    }

    public String getId() {
        return id;
    }

    public String getLottoResultId() {
        return lottoResultId;
    }

    public Money getMoney() {
        return money;
    }
}
