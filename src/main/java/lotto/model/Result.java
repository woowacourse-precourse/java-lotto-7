package lotto.model;

import java.util.Map;

public class Result {

    private final Money money;
    private final Map<Rank, Integer> result;

    public Result(Money money, Lottos lottos, WinningLotto winningLotto) {
        this.money = money;
        this.result = Rank.findAllCount(lottos, winningLotto);
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public float getRateOfReturn() {
        float price = money.getPrice();
        float sum = result.entrySet().stream()
                .mapToInt(e -> e.getKey().getPrize() * e.getValue())
                .sum();
        return sum / price * 100;
    }
}
