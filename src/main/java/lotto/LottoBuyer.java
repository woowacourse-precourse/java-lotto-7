package lotto;

import lotto.money.Money;
import lotto.store.Lotto;
import lotto.store.LottoStore;
import lotto.winner.LottoRank;
import lotto.winner.WinningNumbers;

import java.util.List;
import java.util.stream.Stream;

public class LottoBuyer {
    private final Money seedMoney;
    private final List<Lotto> myLotto;

    public LottoBuyer(LottoStore store, Money seedMoney) {
        myLotto = store.sale(seedMoney);
        if(myLotto.isEmpty())
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다.");

        this.seedMoney = seedMoney;
    }

    public List<LottoRank> result(WinningNumbers winningNumbers) {
        return myLotto.stream()
                .map(winningNumbers::rank)
                .toList();
    }

    public double rateOfReturn(WinningNumbers winningNumbers) {
        Stream<Money> winningsPrices = result(winningNumbers).stream().map(LottoRank::price);
        return (double) sum(winningsPrices) / seedMoney.amount;
    }

    private int sum(Stream<Money> winnings) {
        return winnings.map(p -> p.amount)
                .mapToInt(Integer::intValue).sum();
    }
}
