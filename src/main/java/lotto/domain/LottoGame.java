package lotto.domain;


import java.util.List;

public class LottoGame {
    private final Lottos userLottos;
    private final Money amount;

    public LottoGame(Money money) {
        this.userLottos = new Lottos();
        this.amount = Money.from(money.getMoney());
    }

    public List<Lotto> createLotto(NumberStrategy numberStrategy) {
        return this.userLottos.createLottos(countOfLotto(), numberStrategy);
    }

    public List<Rank> match(Lotto winningLotto, LottoNumber bonusNumber) {
        Lottos totalLotto = new Lottos(getAllLotto());
        return totalLotto.match(winningLotto, bonusNumber);
    }

    public int countOfLotto() {
        return this.amount.countOfBuyLotto();
    }

    public List<Lotto> getAllLotto() {
        return this.userLottos.getAllLotto();
    }

    public double calculateProfit(List<Rank> ranks) {
        Money totalPrize = Money.from(0);
        for (Rank rank : ranks) {
            totalPrize = totalPrize.plus(rank.getPrize());
        }
        return this.amount.calculateProfitRatio(totalPrize);
    }
}
