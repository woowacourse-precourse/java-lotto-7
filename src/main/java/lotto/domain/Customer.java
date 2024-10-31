package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Customer {

    private final Money initialMoney;
    private Money money;
    private List<Lotto> lottos = new ArrayList<>();

    public Customer(Money money) {
        this.initialMoney = money;
        this.money = money;
    }

    public boolean hasMoney(Money money) {
        return this.money.isGreaterEqualThan(money);
    }

    public void buy(Lotto lotto) {
        lottos.add(lotto);
        minusMoney(Lotto.LOTTO_PRICE);
    }

    private void minusMoney(Money money) {
        this.money = this.money.minus(money);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoResult calculateLottoResult(WinningLotto winningLotto) {
        Map<Ranking, Integer> lottoResults = lottos.stream()
                .map(winningLotto::calculateRanking)
                .flatMap(Optional::stream)
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.summingInt(r -> 1)));

        return LottoResult.from(lottoResults, initialMoney);
    }
}
