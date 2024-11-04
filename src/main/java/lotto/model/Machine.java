package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class Machine {
    public static final int LOTTO_PRICE = 1000;

    private int money;
    private int purchaseCount;
    private List<Lotto> lottos;

    public Machine(int money) {
        validate(money);
        this.money = money;
        this.purchaseCount = money / LOTTO_PRICE;
        this.lottos = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new CustomException(ErrorCode.INVALID_MONEY_VALUE);
        }
    }

    public void pickLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}