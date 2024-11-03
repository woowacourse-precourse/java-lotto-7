package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LotteryMachine {
    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> purchaseLotto = new ArrayList<>();
    private final LottoNumberGenerator lottoNumberGenerator;
    private final Money money;

    public LotteryMachine(LottoNumberGenerator lottoNumberGenerator, Money money) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.money = money;
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }

    public Lotto createLottoTicket() {
        return new Lotto(lottoNumberGenerator.generate());
    }

    public int getLottoQuantity() {
        return money.getPaymentAmount() / LOTTO_PRICE;
    }

    public void createLottoByPayment() {
        int amount = getLottoQuantity();
        for (int i = 0; i < amount; i++) {
            purchaseLotto.add(createLottoTicket());
        }
    }
}
