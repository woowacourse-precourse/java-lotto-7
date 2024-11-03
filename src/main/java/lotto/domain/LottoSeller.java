package lotto.domain;

import java.math.BigInteger;
import java.util.List;

public class LottoSeller {
    private final int lottoPrice;
    private final LottoMachine lottoMachine;

    public LottoSeller(int lottoPrice, LottoMachine lottoMachine) {
        this.lottoPrice = lottoPrice;
        this.lottoMachine = lottoMachine;
    }

    public LottoReceipt sellAsMuchAs(BigInteger amount) {
        LottoTicket lottoTicket = createLottoTicketFor(amount);
        return new LottoReceipt(amount, lottoTicket);
    }

    public WinningLotto createWinningLotto(List<Integer> numbers) {
        LottoTicket winningTicket = createLottoTicketFor(numbers);
        return new WinningLotto(winningTicket);
    }

    public LottoTicket createLottoTicketFor(List<Integer> numbers) {
        return new LottoTicket(lottoMachine.createLotto(numbers));
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
