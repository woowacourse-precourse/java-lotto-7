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

    public int countOfLotto() {
        return this.amount.countOfBuyLotto();
    }

    public List<Lotto> getAllLotto() {
        return this.userLottos.getAllLotto();
    }
}
