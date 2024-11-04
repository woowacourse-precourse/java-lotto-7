package lotto.model;

public class LottoBuyer {
    private Lottos lottos;
    private final LottoMachine lottoMachine;

    public LottoBuyer(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos buyLottos(Money purchaseAmount) {
        this.lottos = lottoMachine.sell(purchaseAmount);
        return lottos;
    }
}
