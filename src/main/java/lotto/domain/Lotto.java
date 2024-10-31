package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    private final Amount inputAmount;

    public Lotto(int amount) {
        this.inputAmount = new Amount(amount);
    }

    // TODO: 추가 기능 구현
}
