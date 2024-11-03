package lotto;

import lotto.constant.NumberType;

public class Seller {
    private LottoMachine lottoMachine;

    public Seller(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void sellLottoTo(Person person) {
        long buyQuantity = getBuyQuantity(person.pay());
        Lottos lottos = lottoMachine.publishLottos(buyQuantity);
        person.setLottos(lottos);
    }

    private long getBuyQuantity(Money money) {
        return money.getAmount() / NumberType.LOTTO_PRICE.getPrice();
    }
}
