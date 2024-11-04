package lotto.store;

import lotto.money.Money;
import lotto.store.lotto.Lotto;
import lotto.store.lotto.winner.LottoRank;
import lotto.store.lotto.winner.WinningNumbers;

import java.util.List;

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
        Money buyerProfit = Money.EMPTY;
        for (LottoRank lottoRank : result(winningNumbers))
            buyerProfit = buyerProfit.plus(lottoRank.price());
        return buyerProfit.rateAs(seedMoney);
    }
}
