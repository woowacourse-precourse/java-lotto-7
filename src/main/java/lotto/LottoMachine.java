package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    static final int PRICE = 1000;

    private int cost = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void buy(int cost) {
        validateCostIsPositive(cost);
        validateCostIsDivisibleByPrice(cost);

        this.cost += cost;
        for (int i = 0; i < (cost / PRICE); i++) {
            lottos.add(new Lotto());
        }
    }

    private void validateCostIsPositive(int cost) {
        if (cost <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    private void validateCostIsDivisibleByPrice(int cost) {
        if (cost % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }
}
