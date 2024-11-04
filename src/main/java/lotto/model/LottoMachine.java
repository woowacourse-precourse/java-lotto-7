package lotto.model;

public class LottoMachine {

    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos sell(Money buyAmount) {
        return lottoGenerator.generate(buyAmount);
    }
}
