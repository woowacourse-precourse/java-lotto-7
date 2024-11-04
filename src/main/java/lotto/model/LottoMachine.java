package lotto.model;

public class LottoMachine {
    public Lottos sell(Money buyAmount) {
        return LottoGenerator.generate(buyAmount);
    }
}
