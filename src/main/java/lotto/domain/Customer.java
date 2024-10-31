package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Customer {

    private final Money initialMoney;
    private Money money;
    private List<Lotto> lottos;

    public Customer(Money money) {
        this.initialMoney = money;
        this.money = money;
    }

    public void buyLotto(LottoSeller lottoSeller) {
        lottos = lottoSeller.buy(money);
        minusMoney();
    }

    private void minusMoney() {
        money = money.minus(LottoSeller.LOTTO_PRICE.multiply(Money.from(lottos.size())));
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
