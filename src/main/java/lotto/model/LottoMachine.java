package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;

    public void buyLotto(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액이 로또 금액으로 나누어 떨어지지 않습니다.");
        }
    }
}
