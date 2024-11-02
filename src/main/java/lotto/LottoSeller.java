package lotto;

import java.math.BigInteger;
import java.util.List;

public class LottoSeller {
    private final int lottoPrice;
    private final LottoMachine lottoMachine;

    public LottoSeller(int lottoPrice, LottoMachine lottoMachine) {
        this.lottoPrice = lottoPrice;
        this.lottoMachine = lottoMachine;
    }

    public LottoTicket createLottoTicketFor(BigInteger amount) {
        int quantity = calculateQuantityWith(amount);
        List<Lotto> lottos = lottoMachine.createLottos(quantity);
        return new LottoTicket(lottos);
    }

    private int calculateQuantityWith(BigInteger amount) {
        return amount.divide(BigInteger.valueOf(lottoPrice)).intValue();
    }
}
