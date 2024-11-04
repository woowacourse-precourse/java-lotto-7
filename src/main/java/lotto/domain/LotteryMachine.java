package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.utils.LottoNumberGenerator;

public class LotteryMachine {
    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> purchaseLotto = new ArrayList<>();
    private final LottoNumberGenerator lottoNumberGenerator;

    public LotteryMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> getPurchaseLotto() {
        return purchaseLotto;
    }

    public Lotto createLottoTicket() {
        return new Lotto(lottoNumberGenerator.generate());
    }

    public int getLottoQuantity(Money money) {
        return money.getPaymentAmount() / LOTTO_PRICE;
    }

    public void createLottoByPayment(Money money) {
        int amount = getLottoQuantity(money);
        IntStream.range(0,amount)
                .forEach(i->purchaseLotto.add(createLottoTicket()));
    }
}
