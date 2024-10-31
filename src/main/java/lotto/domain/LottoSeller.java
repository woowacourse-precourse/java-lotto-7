package lotto.domain;

public class LottoSeller {

    public final static Money LOTTO_PRICE = Money.from(1000L);

    private final LottoMachine lottoMachine;

    public LottoSeller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void sellUntilNoMoneyTo(Customer customer) {
        while (customer.hasMoney(LOTTO_PRICE)) {
            customer.buy(lottoMachine.issueLotto());
        }
    }
}
